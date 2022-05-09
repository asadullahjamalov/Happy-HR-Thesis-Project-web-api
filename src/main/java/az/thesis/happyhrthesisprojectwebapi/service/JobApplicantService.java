package az.thesis.happyhrthesisprojectwebapi.service;

import az.thesis.happyhrthesisprojectwebapi.dto.BossAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.dto.JobApplicantResumeDto;
import az.thesis.happyhrthesisprojectwebapi.entity.JobApplicantConfirmToken;
import az.thesis.happyhrthesisprojectwebapi.entity.JobApplicantResume;
import az.thesis.happyhrthesisprojectwebapi.mapper.ResumeMapper;
import az.thesis.happyhrthesisprojectwebapi.repository.JobApplicantConfirmTokenRepo;
import az.thesis.happyhrthesisprojectwebapi.repository.JobApplicantResumeRepo;
import az.thesis.happyhrthesisprojectwebapi.util.MessageUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class JobApplicantService {

    private final JobApplicantResumeRepo jobApplicantResumeRepo;
    private final ResumeMapper resumeMapper;
    private final JobApplicantConfirmTokenRepo jobApplicantConfirmTokenRepo;
    private final MessageUtil messageUtil;

    public JobApplicantService(JobApplicantResumeRepo jobApplicantResumeRepo,
                               ResumeMapper resumeMapper, MessageUtil messageUtil,
                               JobApplicantConfirmTokenRepo jobApplicantConfirmTokenRepo) {
        this.jobApplicantResumeRepo = jobApplicantResumeRepo;
        this.resumeMapper = resumeMapper;
        this.jobApplicantConfirmTokenRepo = jobApplicantConfirmTokenRepo;
        this.messageUtil = messageUtil;
    }

    public JobApplicantResumeDto createJobApplicantResume(JobApplicantResume jobApplicantResume) {
        jobApplicantResumeRepo.save(jobApplicantResume);
        JobApplicantResumeDto jobApplicantResumeDto = resumeMapper.jobApplicantResumeEntityToDto(jobApplicantResume);
        this.createToken(jobApplicantResume);
        return jobApplicantResumeDto;
    }

    public void createToken(JobApplicantResume jobApplicantResume) {
        String token = jobApplicantConfirmTokenRepo
                .save(JobApplicantConfirmToken.builder()
                        .jobApplicantResume(jobApplicantResume)
                        .confirmationToken(UUID.randomUUID().toString())
                        .createdDate(LocalDateTime.now())
                        .build())
                .getConfirmationToken();
        messageUtil.regVerifyNotification(jobApplicantResume, token);
    }

    public void verifyToken(String token) {
        JobApplicantConfirmToken dbToken = jobApplicantConfirmTokenRepo
                .getJobApplicantConfirmTokenByConfirmationToken(token);
        JobApplicantResume jobApplicantResume = jobApplicantResumeRepo
                .getJobApplicantResumeByEmail(dbToken.getJobApplicantResume().getEmail());
        jobApplicantResumeRepo.changeIsActiveByEmail(dbToken.getJobApplicantResume().getEmail());
        jobApplicantConfirmTokenRepo.delete(dbToken);
        messageUtil.successRegister(jobApplicantResume);
    }

    public List<JobApplicantResumeDto> getAllJobApplicantResumes() {
        return resumeMapper.jobApplicantEntityListToDtoList(
                jobApplicantResumeRepo.getJobApplicantResumeByIsActive(true));
    }

    public List<JobApplicantResumeDto> getAllJobApplicantResumesByAge(int age) {
        return resumeMapper.jobApplicantEntityListToDtoList(
                jobApplicantResumeRepo.getJobApplicantResumeByIsActiveAndAge(age, true));
    }

    public List<JobApplicantResumeDto> getAllJobApplicantResumesByAgeInterval(int minAge, int maxAge) {
        return resumeMapper.jobApplicantEntityListToDtoList(
                jobApplicantResumeRepo.getJobApplicantResumesByAgeIntervalAndIsActiveIsTrue(minAge, maxAge, true));
    }

    public List<JobApplicantResumeDto> getAllJobApplicantResumesBySalary(int salary) {
        return resumeMapper.jobApplicantEntityListToDtoList(
                jobApplicantResumeRepo.getJobApplicantResumesBySalaryAndIsActiveIsTrue(salary, true));
    }

    public List<JobApplicantResumeDto> getAllJobApplicantResumesBySalaryInterval(int minSalary, int maxSalary) {
        return resumeMapper.jobApplicantEntityListToDtoList(
                jobApplicantResumeRepo.getJobApplicantResumesBySalaryIntervalAndIsActiveIsTrue(minSalary, maxSalary, true));
    }

}

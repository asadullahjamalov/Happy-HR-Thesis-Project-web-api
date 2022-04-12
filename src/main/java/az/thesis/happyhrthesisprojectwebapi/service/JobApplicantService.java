package az.thesis.happyhrthesisprojectwebapi.service;

import az.thesis.happyhrthesisprojectwebapi.dto.JobApplicantResumeDto;
import az.thesis.happyhrthesisprojectwebapi.mapper.ResumeMapper;
import az.thesis.happyhrthesisprojectwebapi.repository.JobApplicantResumeRepo;
import org.springframework.stereotype.Service;

@Service
public class JobApplicantService {

    private final JobApplicantResumeRepo jobApplicantResumeRepo;
    private final ResumeMapper resumeMapper;

    public JobApplicantService(JobApplicantResumeRepo jobApplicantResumeRepo,
                               ResumeMapper resumeMapper) {
        this.jobApplicantResumeRepo = jobApplicantResumeRepo;
        this.resumeMapper = resumeMapper;
    }

    public JobApplicantResumeDto createJobApplicantResume(JobApplicantResumeDto jobApplicantResumeDto) {
        return resumeMapper.jobApplicantResumeEntityToDto(
                jobApplicantResumeRepo.save(
                        resumeMapper.jobApplicantResumeDtoToEntity(jobApplicantResumeDto)));
    }

}

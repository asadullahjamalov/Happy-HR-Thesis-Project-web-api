package az.thesis.happyhrthesisprojectwebapi.controller;

import az.thesis.happyhrthesisprojectwebapi.dto.BossAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.dto.JobApplicantResumeDto;
import az.thesis.happyhrthesisprojectwebapi.dto.MessageDto;
import az.thesis.happyhrthesisprojectwebapi.entity.JobApplicantResume;
import az.thesis.happyhrthesisprojectwebapi.service.JobApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/job-applicants")
public class JobApplicantController {

    private final JobApplicantService jobApplicantService;

    public JobApplicantController(JobApplicantService jobApplicantService) {
        this.jobApplicantService = jobApplicantService;
    }

    @PostMapping("/create")
    public ResponseEntity<MessageDto> createJobApplicantResume
            (@RequestBody JobApplicantResume jobApplicantResume) {
        jobApplicantService.createJobApplicantResume(jobApplicantResume);
        log.info("Job Applicant Resume is created , successfully");
        return new ResponseEntity<>(new MessageDto("Please, confirm your email"), HttpStatus.CREATED);
    }

    @GetMapping("/confirm")
    public ResponseEntity<MessageDto> confirmJobApplicantResume
            (@RequestParam("token") String confirmationToken) {
        jobApplicantService.verifyToken(confirmationToken);
        log.info("Job Applicant Resume is confirmed , successfully");
        return new ResponseEntity(new MessageDto("You completed registration, successfully"), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobApplicantResumeDto>> getAllJobApplicantResumes() {
        log.info("Get all JobApplicantResumes ,successfully");
        return new ResponseEntity<>(jobApplicantService.getAllJobApplicantResumes(), HttpStatus.OK);
    }

    @GetMapping("/by-age")
    public ResponseEntity<List<JobApplicantResumeDto>> getAllJobApplicantResumesByAge(@RequestParam(value = "age") int age) {
        log.info("Get all JobApplicantResumes by age ,successfully");
        return new ResponseEntity<>(jobApplicantService.getAllJobApplicantResumesByAge(age), HttpStatus.OK);
    }

    @GetMapping("/by-age-interval")
    public ResponseEntity<List<JobApplicantResumeDto>> getAllJobApplicantResumesByAgeInterval(@RequestParam(value = "minAge") int minAge,
                                                                                              @RequestParam(value = "maxAge") int maxAge) {
        log.info("Get all JobApplicantResumes by age interval ,successfully");
        return new ResponseEntity<>(jobApplicantService.getAllJobApplicantResumesByAgeInterval(minAge, maxAge), HttpStatus.OK);
    }

    @GetMapping("/by-salary")
    public ResponseEntity<List<JobApplicantResumeDto>> getAllJobApplicantResumesBySalary(@RequestParam(value = "salary") int salary) {
        log.info("Get all JobApplicantResumes by salary ,successfully");
        return new ResponseEntity<>(jobApplicantService.getAllJobApplicantResumesBySalary(salary), HttpStatus.OK);
    }

    @GetMapping("/by-salary-interval")
    public ResponseEntity<List<JobApplicantResumeDto>> getAllJobApplicantResumesBySalaryInterval(@RequestParam(value = "minSalary") int minSalary,
                                                                                                 @RequestParam(value = "maxSalary") int maxSalary) {
        log.info("Get all JobApplicantResumes by salary interval ,successfully");
        return new ResponseEntity<>(jobApplicantService.getAllJobApplicantResumesBySalaryInterval(minSalary, maxSalary), HttpStatus.OK);
    }

}

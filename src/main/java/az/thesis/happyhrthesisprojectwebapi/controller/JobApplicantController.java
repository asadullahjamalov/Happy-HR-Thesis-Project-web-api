package az.thesis.happyhrthesisprojectwebapi.controller;

import az.thesis.happyhrthesisprojectwebapi.dto.JobApplicantResumeDto;
import az.thesis.happyhrthesisprojectwebapi.service.JobApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/job-applicants")
public class JobApplicantController {

    private final JobApplicantService jobApplicantService;

    public JobApplicantController(JobApplicantService jobApplicantService) {
        this.jobApplicantService = jobApplicantService;
    }

    @PostMapping
    public ResponseEntity<JobApplicantResumeDto> createJobApplicantResume
            (@RequestBody JobApplicantResumeDto jobApplicantResumeDto) {
        log.info("Job Applicant Resume is created , successfully");
        return new ResponseEntity<>(jobApplicantService.
                createJobApplicantResume(jobApplicantResumeDto), HttpStatus.CREATED);
    }

}

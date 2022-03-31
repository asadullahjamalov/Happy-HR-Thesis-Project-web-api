package az.thesis.happyhrthesisprojectwebapi.controller;

import az.thesis.happyhrthesisprojectwebapi.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/boss-az")
    public ResponseEntity<List<String>> getAllBossAzResumeLinks() throws IOException {
        log.info("Get all BossAzResumeLinks successfully");
        return new ResponseEntity<>(resumeService.getAllBossAzResumeLinks(), HttpStatus.OK);
    }


    @GetMapping("/smart_job-az")
    public ResponseEntity<Integer> getAllSmartJobAzResumeLinks() throws IOException, InterruptedException {
        log.info("Get all SmartJobAzResumeLinks successfully");
        return new ResponseEntity<>(resumeService.getAllSmartJobAzResumeLinks(), HttpStatus.OK);
    }
}

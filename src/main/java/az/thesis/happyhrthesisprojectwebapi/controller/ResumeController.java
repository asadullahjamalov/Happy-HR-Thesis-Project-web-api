package az.thesis.happyhrthesisprojectwebapi.controller;

import az.thesis.happyhrthesisprojectwebapi.service.BossAzResumeService;
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

    private final BossAzResumeService bossAzResumeService;

    public ResumeController(BossAzResumeService bossAzResumeService) {
        this.bossAzResumeService = bossAzResumeService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllBossAzResumeLinks() throws IOException {
        log.info("Get all BossAzResumeLinks successfully");
        return new ResponseEntity<>(bossAzResumeService.getAllBossAzResumeLinks(), HttpStatus.OK);
    }
}

package az.thesis.happyhrthesisprojectwebapi.controller;

import az.thesis.happyhrthesisprojectwebapi.dto.BossAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.dto.SmartJobAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

//    @GetMapping("/boss-az")
//    public ResponseEntity<List<String>> getAllBossAzResumeLinks() throws IOException {
//        log.info("Get all BossAzResumeLinks successfully");
//        return new ResponseEntity<>(resumeService.getAllBossAzResumeLinks(), HttpStatus.OK);
//    }
//
//    @GetMapping("/smart_job-az")
//    public ResponseEntity<Integer> getAllSmartJobAzResumeLinks() throws IOException {
//        log.info("Get all SmartJobAzResumeLinks successfully");
//        return new ResponseEntity<>(resumeService.getAllSmartJobAzResumeLinks(), HttpStatus.OK);
//    }


    @GetMapping("/boss-az/by-age")
    public ResponseEntity<List<BossAzResumeDto>> getAllBossAzResumesByAge(@RequestParam(value = "age") int age) {
        log.info("Get all BossAzResumes by age ,successfully");
        return new ResponseEntity<>(resumeService.getAllBossAzResumesByAge(age), HttpStatus.OK);
    }

    @GetMapping("/boss-az/by-age-interval")
    public ResponseEntity<List<BossAzResumeDto>> getAllBossAzResumesByAgeInterval(@RequestParam(value = "minAge") int minAge,
                                                                                  @RequestParam(value = "maxAge") int maxAge) {
        log.info("Get all BossAzResumes by age interval ,successfully");
        return new ResponseEntity<>(resumeService.getAllBossAzResumesByAgeInterval(minAge, maxAge), HttpStatus.OK);
    }

    @GetMapping("/boss-az/by-salary")
    public ResponseEntity<List<BossAzResumeDto>> getAllBossAzResumesBySalary(@RequestParam(value = "salary") int salary) {
        log.info("Get all BossAzResumes by salary ,successfully");
        return new ResponseEntity<>(resumeService.getAllBossAzResumesBySalary(salary), HttpStatus.OK);
    }

    @GetMapping("/boss-az/by-salary-interval")
    public ResponseEntity<List<BossAzResumeDto>> getAllBossAzResumesBySalaryInterval(@RequestParam(value = "minSalary") int minSalary,
                                                                                     @RequestParam(value = "maxSalary") int maxSalary) {
        log.info("Get all BossAzResumes by salary interval ,successfully");
        return new ResponseEntity<>(resumeService.getAllBossAzResumesBySalaryInterval(minSalary, maxSalary), HttpStatus.OK);
    }

    @GetMapping("/smart_job-az/by-salary")
    public ResponseEntity<List<SmartJobAzResumeDto>> getAllSmartJobAzResumesBySalary(@RequestParam(value = "salary") Double salary) {
        log.info("Get all SmartJobAzResumes by salary ,successfully");
        return new ResponseEntity<>(resumeService.getAllSmartJobAzResumesBySalary(salary), HttpStatus.OK);
    }

    @GetMapping("/smart_job-az/by-salary-interval")
    public ResponseEntity<List<SmartJobAzResumeDto>> getAllSmartJobAzResumesBySalaryInterval(@RequestParam(value = "minSalary") Double minSalary,
                                                                                             @RequestParam(value = "maxSalary") Double maxSalary) {
        log.info("Get all SmartJobAzResumes by salary interval ,successfully");
        return new ResponseEntity<>(resumeService.getAllSmartJobAzResumesBySalaryInterval(minSalary, maxSalary), HttpStatus.OK);
    }

}

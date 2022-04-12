package az.thesis.happyhrthesisprojectwebapi.service;

import az.thesis.happyhrthesisprojectwebapi.dto.BossAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.dto.SmartJobAzResumeDto;
import az.thesis.happyhrthesisprojectwebapi.mapper.ResumeMapper;
import az.thesis.happyhrthesisprojectwebapi.repository.BossAzResumeRepo;
import az.thesis.happyhrthesisprojectwebapi.repository.SmartJobAzResumeRepo;
import az.thesis.happyhrthesisprojectwebapi.scraper.BossAzResumeScraper;
import az.thesis.happyhrthesisprojectwebapi.scraper.SmartJobAzResumeScraper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ResumeService {

    private final BossAzResumeScraper bossAzResumeScraper;
    private final SmartJobAzResumeScraper smartJobAzResumeScraper;
    private final ResumeMapper ResumeMapper;
    private final BossAzResumeRepo bossAzResumeRepo;
    private final SmartJobAzResumeRepo smartJobAzResumeRepo;

    public ResumeService(BossAzResumeScraper bossAzResumeScraper,
                         SmartJobAzResumeScraper smartJobAzResumeScraper,
                         ResumeMapper ResumeMapper,
                         BossAzResumeRepo bossAzResumeRepo,
                         SmartJobAzResumeRepo smartJobAzResumeRepo) {
        this.bossAzResumeScraper = bossAzResumeScraper;
        this.smartJobAzResumeScraper = smartJobAzResumeScraper;
        this.ResumeMapper = ResumeMapper;
        this.bossAzResumeRepo = bossAzResumeRepo;
        this.smartJobAzResumeRepo = smartJobAzResumeRepo;
    }

//    public List<String> getAllBossAzResumeLinks() throws IOException {
//        bossAzResumeScraper.getBossAzResumes();
//        return bossAzResumeScraper.getBossAzResumeLinks();
//    }
//
//
//    public int getAllSmartJobAzResumeLinks() throws IOException {
//        smartJobAzResumeScraper.getSmartJobAzResumes();
//        return smartJobAzResumeScraper.getTotalPageNumber();
//    }

    public void updateScrapedResumeDatabase() throws IOException {
        bossAzResumeRepo.deleteAll();
        smartJobAzResumeRepo.deleteAll();
        bossAzResumeScraper.getBossAzResumes();
        smartJobAzResumeScraper.getSmartJobAzResumes();
    }

    public List<BossAzResumeDto> getAllBossAzResumesByAge(int age) {
        return ResumeMapper.bossAzEntityListToDtoList(bossAzResumeRepo.getBossAzResumesByAge(age));
    }

    public List<BossAzResumeDto> getAllBossAzResumesByAgeInterval(int minAge, int maxAge) {
        return ResumeMapper.bossAzEntityListToDtoList(
                bossAzResumeRepo.getBossAzResumesByAgeInterval(minAge, maxAge));
    }

    public List<BossAzResumeDto> getAllBossAzResumesBySalary(int salary) {
        return ResumeMapper.bossAzEntityListToDtoList(bossAzResumeRepo.getBossAzResumesBySalary(salary));
    }

    public List<BossAzResumeDto> getAllBossAzResumesBySalaryInterval(int minSalary, int maxSalary) {
        return ResumeMapper.bossAzEntityListToDtoList(
                bossAzResumeRepo.getBossAzResumesBySalaryInterval(minSalary, maxSalary));
    }

    public List<SmartJobAzResumeDto> getAllSmartJobAzResumesBySalary(Double salary) {
        return ResumeMapper.smartJobAzEntityListToDtoList(
                smartJobAzResumeRepo.getSmartJobAzResumesBySalary(salary));
    }

    public List<SmartJobAzResumeDto> getAllSmartJobAzResumesBySalaryInterval(Double minSalary, Double maxSalary) {
        return ResumeMapper.smartJobAzEntityListToDtoList(
                smartJobAzResumeRepo.getSmartJobAzResumesBySalaryInterval(minSalary, maxSalary));
    }

}

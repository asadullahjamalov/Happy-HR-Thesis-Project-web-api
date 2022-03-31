package az.thesis.happyhrthesisprojectwebapi.service;

import az.thesis.happyhrthesisprojectwebapi.scraper.BossAzResumeScraper;
import az.thesis.happyhrthesisprojectwebapi.scraper.SmartJobAzResumeScraper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ResumeService {

    private final BossAzResumeScraper bossAzResumeScraper;
    private final SmartJobAzResumeScraper smartJobAzResumeScraper;

    public ResumeService(BossAzResumeScraper bossAzResumeScraper,
                         SmartJobAzResumeScraper smartJobAzResumeScraper) {
        this.bossAzResumeScraper = bossAzResumeScraper;
        this.smartJobAzResumeScraper = smartJobAzResumeScraper;
    }

    public List<String> getAllBossAzResumeLinks() throws IOException {
        bossAzResumeScraper.getBossAzResumes();
        return bossAzResumeScraper.getBossAzResumeLinks();
    }


    public int getAllSmartJobAzResumeLinks() throws IOException, InterruptedException {
        smartJobAzResumeScraper.getSmartJobAzResumes();
//        System.out.println(smartJobAzResumeScraper.getTotalPageNumber());
//        System.out.println(smartJobAzResumeScraper.getSmartJobAzResumeLinks());
        return smartJobAzResumeScraper.getTotalPageNumber();
//        return bossAzResumeScraper.getBossAzResumeLinks();
    }
}

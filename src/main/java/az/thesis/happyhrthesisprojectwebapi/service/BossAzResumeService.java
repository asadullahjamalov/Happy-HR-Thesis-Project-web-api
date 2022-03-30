package az.thesis.happyhrthesisprojectwebapi.service;

import az.thesis.happyhrthesisprojectwebapi.scraper.BossAzResumeScraper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BossAzResumeService {

    private final BossAzResumeScraper bossAzResumeScraper;

    public BossAzResumeService(BossAzResumeScraper bossAzResumeScraper) {
        this.bossAzResumeScraper = bossAzResumeScraper;
    }

    public List<String> getAllBossAzResumeLinks() throws IOException {
        bossAzResumeScraper.getBossAzResumes();
        return bossAzResumeScraper.getBossAzResumeLinks();
    }
}

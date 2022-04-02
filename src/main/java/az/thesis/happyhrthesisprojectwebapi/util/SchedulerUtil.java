package az.thesis.happyhrthesisprojectwebapi.util;

import az.thesis.happyhrthesisprojectwebapi.scraper.BossAzResumeScraper;
import az.thesis.happyhrthesisprojectwebapi.scraper.SmartJobAzResumeScraper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SchedulerUtil {

    private final BossAzResumeScraper bossAzResumeScraper;
    private final SmartJobAzResumeScraper smartJobAzResumeScraper;

    public SchedulerUtil(BossAzResumeScraper bossAzResumeScraper,
                         SmartJobAzResumeScraper smartJobAzResumeScraper) {
        this.bossAzResumeScraper = bossAzResumeScraper;
        this.smartJobAzResumeScraper = smartJobAzResumeScraper;
    }

    @Scheduled(cron = "0 0 1 * * ?", zone = "Asia/Baku")
    public void saveResumesToDatabase() throws IOException {
       bossAzResumeScraper.getBossAzResumes();
       smartJobAzResumeScraper.getSmartJobAzResumes();
    }

}

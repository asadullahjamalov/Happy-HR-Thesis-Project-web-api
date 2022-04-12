package az.thesis.happyhrthesisprojectwebapi.util;

import az.thesis.happyhrthesisprojectwebapi.service.ResumeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SchedulerUtil {

    private final ResumeService resumeService;

    public SchedulerUtil(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @Scheduled(cron = "0 0 * * *", zone = "Asia/Baku")
    public void updateResumeDatabase() throws IOException {
        resumeService.updateScrapedResumeDatabase();
    }

}

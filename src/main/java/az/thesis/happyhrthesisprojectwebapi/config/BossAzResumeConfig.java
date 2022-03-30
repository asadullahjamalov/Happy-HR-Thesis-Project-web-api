package az.thesis.happyhrthesisprojectwebapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "boss.az.scraper.base")
@Configuration("bossAzResumeProperties")
public class BossAzResumeConfig {

    private String urlFirstPart;
    private String urlSecondPart;
    private String mainUrl;
    private int numberOfResumesInOnePage;

    public String getUrlFirstPart() {
        return urlFirstPart;
    }

    public void setUrlFirstPart(String urlFirstPart) {
        this.urlFirstPart = urlFirstPart;
    }

    public String getUrlSecondPart() {
        return urlSecondPart;
    }

    public void setUrlSecondPart(String urlSecondPart) {
        this.urlSecondPart = urlSecondPart;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public int getNumberOfResumesInOnePage() {
        return numberOfResumesInOnePage;
    }

    public void setNumberOfResumesInOnePage(int numberOfResumesInOnePage) {
        this.numberOfResumesInOnePage = numberOfResumesInOnePage;
    }
}
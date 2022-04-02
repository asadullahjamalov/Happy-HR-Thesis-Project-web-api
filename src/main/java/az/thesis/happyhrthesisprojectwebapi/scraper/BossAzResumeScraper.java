package az.thesis.happyhrthesisprojectwebapi.scraper;

import az.thesis.happyhrthesisprojectwebapi.config.BossAzResumeConfig;
import az.thesis.happyhrthesisprojectwebapi.entity.BossAzResume;
import az.thesis.happyhrthesisprojectwebapi.repository.BossAzResumeRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BossAzResumeScraper {

    private final BossAzResumeRepo bossAzResumeRepo;
    private final BossAzResumeConfig bossAzResumeProperties;

    public BossAzResumeScraper(BossAzResumeRepo bossAzResumeRepo,
                               BossAzResumeConfig bossAzResumeProperties) {
        this.bossAzResumeRepo = bossAzResumeRepo;
        this.bossAzResumeProperties = bossAzResumeProperties;
    }

    public int getTotalPageNumber() throws IOException {
        Document document = Jsoup.connect(bossAzResumeProperties.getUrlFirstPart() + "1"
                + bossAzResumeProperties.getUrlSecondPart()).get();
        Elements elements = document.getElementsByClass("results-header-found");
        String[] arr = Arrays.stream(elements.toString().split(" CV")).findFirst()
                .get().split(">").clone();
        return Integer.parseInt(arr[1]) / bossAzResumeProperties.getNumberOfResumesInOnePage();
    }

    public List<String> getBossAzResumeLinks() throws IOException {
        int totalPageNumber = getTotalPageNumber();
        List<String> resumeLinks = new ArrayList<>();
        for (int page = 1; page <= totalPageNumber; page++) {
            System.out.println("Request sending...");
            Document document = Jsoup.connect(bossAzResumeProperties.getUrlFirstPart() + page
                    + bossAzResumeProperties.getUrlSecondPart()).get();
            Elements elements = document.getElementsByClass("results-i-link");
            for (Element element : elements) {
                resumeLinks.add(element.attr("href"));
            }

        }
        return resumeLinks;
    }

    public void getBossAzResumes() throws IOException {
        List<String> resumeLinks = getBossAzResumeLinks();

        for (String resumeLink : resumeLinks) {
            Document document = Jsoup.connect(bossAzResumeProperties.getMainUrl() + resumeLink).get();
            Elements occupationElement = document.getElementsByClass("post-title");
            Elements salaryElement = document.getElementsByClass("post-salary salary");
            Elements nameElement = document.getElementsByClass("full_name params-i-val");
            Elements cityElement = document.getElementsByClass("region params-i-val");
            Elements ageElement = document.getElementsByClass("age params-i-val");
            Elements genderElement = document.getElementsByClass("gender params-i-val");
            Elements bumpedTimeElement = document.getElementsByClass("bumped_on params-i-val");
            Elements expireTimeElement = document.getElementsByClass("expires_on params-i-val");
            Elements phoneElement = document.getElementsByClass("phone params-i-val");
            Elements skillsElement = document.getElementsByClass("skills params-i-val");
            Elements educationElement = document.getElementsByClass("education params-i-val");
            Elements educationDetailsElement = document.getElementsByClass("education_info params-i-val");
            Elements experienceElement = document.getElementsByClass("experience params-i-val");
            Elements experienceDetailsElement = document.getElementsByClass("experience_info params-i-val");
            Elements additionalInfoElement = document.getElementsByClass("personal params-i-val");

            bossAzResumeRepo.save(new BossAzResume().toBuilder().additionalInfo(additionalInfoElement.text())
                    .age(Integer.parseInt(ageElement.text().split(" ").clone()[0]))
                    .bumpedTime(bumpedTimeElement.text()).expireTime(expireTimeElement.text()).city(cityElement.text())
                    .education(educationElement.text()).educationDetails(educationDetailsElement.text())
                    .experience(experienceElement.text()).experienceDetails(experienceDetailsElement.text())
                    .gender(genderElement.text()).name(nameElement.text())
                    .salary(Integer.parseInt(salaryElement.text().split(" ").clone()[0]))
                    .occupation(occupationElement.text()).skills(skillsElement.text()).phone(phoneElement.text())
                    .build());

        }
    }


}

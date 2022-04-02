package az.thesis.happyhrthesisprojectwebapi.scraper;

import az.thesis.happyhrthesisprojectwebapi.config.SmartJobAzResumeConfig;
import az.thesis.happyhrthesisprojectwebapi.entity.SmartJobAzResume;
import az.thesis.happyhrthesisprojectwebapi.repository.SmartJobAzResumeRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SmartJobAzResumeScraper {

    private final SmartJobAzResumeRepo smartJobAzResumeRepo;
    private final SmartJobAzResumeConfig smartJobAzResumeProperties;

    public SmartJobAzResumeScraper(SmartJobAzResumeRepo smartJobAzResumeRepo,
                                   SmartJobAzResumeConfig smartJobAzResumeProperties) {
        this.smartJobAzResumeRepo = smartJobAzResumeRepo;
        this.smartJobAzResumeProperties = smartJobAzResumeProperties;
    }


    public int getTotalPageNumber() throws IOException {
        Document document = Jsoup.connect(smartJobAzResumeProperties.getUrlFirstPart() + "1").get();
        Elements elements = document.getElementsByClass("cvCountSpan");
        return Integer.parseInt(elements.text()) / smartJobAzResumeProperties.getNumberOfResumesInOnePage();
    }

    public List<String> getSmartJobAzResumeLinks() throws IOException {
        int totalPageNumber = getTotalPageNumber();
        List<String> resumeLinks = new ArrayList<>();
        for (int page = 1; page <= totalPageNumber; page++) {
            System.out.println("Request sending...");
            Document document = Jsoup.connect(smartJobAzResumeProperties.getUrlFirstPart() + page
                    + smartJobAzResumeProperties.getUrlSecondPart()).get();
            Elements elements = document.getElementsByClass("myBtn  ");
            for (Element element : elements) {
                resumeLinks.add(element.attr("href"));
            }
        }
        return resumeLinks;
    }


    public void getSmartJobAzResumes() throws IOException {

        List<String> resumeLinks = getSmartJobAzResumeLinks();
        for (String resumeLink : resumeLinks) {
            Document document = Jsoup.connect(resumeLink).ignoreHttpErrors(true).get();

            if (!document.title().equals("Exception")) {

                Elements nameElement = document.getElementsByClass("vacance__sjlocation");
                Elements mainElements = document.getElementsByClass("vacance__overview--text");
                List<Element> elementList = mainElements.stream().collect(Collectors.toList());

                List<String> resumeDetails = new ArrayList<>();
                for (Element element : elementList) {
                    resumeDetails.add(element.text());
                }

                smartJobAzResumeRepo.save(new SmartJobAzResume().toBuilder().name(nameElement.text())
                        .hasDrivingLicence(resumeDetails.get(0)).hasCar(resumeDetails.get(1))
                        .workingTime(resumeDetails.get(2)).about(resumeDetails.get(3))
                        .minimumSalary(Double.parseDouble(resumeDetails.get(4).split(" ").clone()[0]))
                        .gender(resumeDetails.get(5))
                        .birthDate(resumeDetails.get(6)).education(resumeDetails.get(7))
                        .experience(resumeDetails.get(8)).city(resumeDetails.get(9))
                        .address(resumeDetails.get(10)).phone(resumeDetails.get(11)).build());

            }
        }
    }


}

package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
//    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";
    private static final String SITE_URL = "https://moikrug.ru";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        try {
            int pageNumber = 0;
            Document document = getDocument(searchString, pageNumber);

            while (true) {
                Elements elements = document.getElementsByClass("job");

                if (elements.size() == 0) {
                    break;
                }

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName(SITE_URL);

                    Element salaryElement = element.getElementsByClass("salary").first();
                    String salary = salaryElement.text();
                    vacancy.setSalary(salary.length() == 0 ? "" : salary);

                    Element infoElement = element.getElementsByClass("info").first();
                    vacancy.setCity(infoElement.getElementsByClass("location").text());
                    vacancy.setCompanyName(infoElement.getElementsByClass("company_name").text());

                    Element titleElement = infoElement.getElementsByClass("title").first();
                    vacancy.setTitle(titleElement.text());

                    String link = SITE_URL + titleElement.getElementsByTag("a").attr("href");
                    vacancy.setUrl(link);

                    vacancies.add(vacancy);
                }

                pageNumber++;
                document = getDocument(searchString, pageNumber);
            }

        } catch (IOException ignore) {
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document document = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                .referrer("")
                .get();

        return document;
    }
}

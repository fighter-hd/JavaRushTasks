package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/"
                                    + this.getClass().getPackage().getName().replace('.', '/')
                            //todo
                                    + "/vacanciesCopy.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String stringContent = getUpdatedFileContent(vacancies);
            updateFile(stringContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList) {
        Document document = null;

        try {
            document = getDocument();
            Element templateOriginal = document.getElementsByClass("template").first();
            Element templateCopy = templateOriginal.clone();

            templateCopy.removeAttr("style");
            templateCopy.removeClass("template");

            document.getAllElements().stream().filter(e -> e.className().equals("vacancy")).forEach(Element::remove);

            for (Vacancy vacancy : vacancyList) {
                Element localClone = templateCopy.clone();

                localClone.getElementsByAttributeValueContaining("class", "city").first().text(vacancy.getCity());
                localClone.getElementsByAttributeValueContaining("class", "companyName").first().text(vacancy.getCompanyName());
                localClone.getElementsByAttributeValueContaining("class", "salary").first().text(vacancy.getSalary());

                Element linkElement = localClone.getElementsByTag("a").first();
                linkElement.text(vacancy.getTitle());
                linkElement.attr("href", vacancy.getUrl());

                templateOriginal.before(localClone.outerHtml());
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }

        return document.html();
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String stringContent) {
        File file = new File(filePath);

        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {

            writer.write(stringContent);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
}

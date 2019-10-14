package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/"
                                    + this.getClass().getPackage().getName().replace('.', '/')
                                    + "/vacancies.html";

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
        return null;
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

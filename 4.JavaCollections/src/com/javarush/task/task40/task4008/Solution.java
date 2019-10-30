package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        String result = null;

        if (date.matches("\\d{1,2}[.]\\d{1,2}[.]\\d{4}[ ]\\d{1,2}[:]\\d{2}[:]\\d{2}")) {
            String[] dateAndTimeArray = date.split(" ");
            String smallDate = dateAndTimeArray[0];
            String time = dateAndTimeArray[1];

            LocalDate localDate = LocalDate.parse(smallDate, DateTimeFormatter.ofPattern("d.M.yyyy"));
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm:ss"));
            result = getFullDateResult(localDate, localTime);

        } else if (date.matches("\\d{1,2}[.]\\d{1,2}[.]\\d{4}")) {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d.M.yyyy"));
            result = getDateResult(localDate);

        } else if (date.matches("\\d{1,2}[:]\\d{2}[:]\\d{2}")) {
            LocalTime localTime = LocalTime.parse(date, DateTimeFormatter.ofPattern("H:mm:ss"));
            result = getTimeResult(localTime);
        }

        System.out.print(result);
    }

    private static String getFullDateResult(LocalDate localDate, LocalTime localTime) {
        StringBuilder result = new StringBuilder();
        result.append(getDateResult(localDate));
        result.append(getTimeResult(localTime));

        return result.toString();
    }

    private static String getDateResult(LocalDate localDate) {
        StringBuilder dateBuilder = new StringBuilder();

        dateBuilder.append("День: ");
        dateBuilder.append(localDate.getDayOfMonth());
        dateBuilder.append("\n");

        dateBuilder.append("День недели: ");
        dateBuilder.append(localDate.getDayOfWeek().getValue());
        dateBuilder.append("\n");

        dateBuilder.append("День месяца: ");
        dateBuilder.append(localDate.getDayOfMonth());
        dateBuilder.append("\n");

        dateBuilder.append("День года: ");
        dateBuilder.append(localDate.getDayOfYear());
        dateBuilder.append("\n");

        dateBuilder.append("Неделя месяца: ");
        dateBuilder.append(localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
        dateBuilder.append("\n");

        dateBuilder.append("Неделя года: ");
        dateBuilder.append(localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        dateBuilder.append("\n");

        dateBuilder.append("Месяц: ");
        dateBuilder.append(localDate.getMonthValue());
        dateBuilder.append("\n");

        dateBuilder.append("Год: ");
        dateBuilder.append(localDate.getYear());
        dateBuilder.append("\n");

        return dateBuilder.toString();
    }

    private static String getTimeResult(LocalTime localTime) {
        StringBuilder dateBuilder = new StringBuilder();

        dateBuilder.append("AM или PM: ");
        dateBuilder.append(localTime.getHour() < 13 ? "AM" : "PM");
        dateBuilder.append("\n");

        dateBuilder.append("Часы: ");
        int hour = localTime.getHour();
        dateBuilder.append(localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        dateBuilder.append("\n");

        dateBuilder.append("Часы дня: ");
        dateBuilder.append(localTime.getHour());
        dateBuilder.append("\n");

        dateBuilder.append("Минуты: ");
        dateBuilder.append(localTime.getMinute());
        dateBuilder.append("\n");

        dateBuilder.append("Секунды: ");
        dateBuilder.append(localTime.getSecond());
        dateBuilder.append("\n");

        return dateBuilder.toString();
    }
}

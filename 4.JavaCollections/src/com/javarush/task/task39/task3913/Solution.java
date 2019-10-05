package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\Gans\\Desktop\\Java_instructions\\For_Tests"));
        testGetNumberOfUniqueIPs(logParser);
        testGetUniqueIPs(logParser);
        testGetIPsForUser(logParser);
        testGetIPsForEvent(logParser);
        testGetIPsForStatus(logParser);
    }

    private static void testGetNumberOfUniqueIPs(LogParser logParser) {
        System.out.println("testGetNumberOfUniqueIPs");
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));  // 3
        System.out.println(logParser.getNumberOfUniqueIPs(new Date(), null));  // 4

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        try {
            start = format.parse("30.08.2012 16:08:40");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(logParser.getNumberOfUniqueIPs(start, null)); // 5
    }

    private static void testGetUniqueIPs(LogParser logParser) {
        System.out.println("\n======================================================================================");
        System.out.println("testGetUniqueIPs");

        Set<String> IPs = logParser.getUniqueIPs(null, null);
        IPs.stream().forEach(System.out::println);

//        IPs = logParser.getUniqueIPs(null, new Date());
//        IPs.stream().forEach(System.out::println);
    }

    private static void testGetIPsForUser(LogParser logParser) {
        System.out.println("\n======================================================================================");
        System.out.print("testGetIPsForUser");

        String user = "Vasya Pupkin";
        System.out.println(": " + user);

        Set<String> userIPs = logParser.getIPsForUser(user, null, null);
//        Set<String> userIPs = logParser.getIPsForUser(user, null, new Date());
        userIPs.stream().forEach(System.out::println);
    }

    private static void testGetIPsForEvent(LogParser logParser) {
        System.out.println("\n======================================================================================");
        System.out.print("testGetIPsForEvent");

        Event event = Event.LOGIN;
//        Event event = Event.WRITE_MESSAGE;
//        Event event = Event.SOLVE_TASK;
        System.out.println(": " + event.name());

        Set<String> userIPs = logParser.getIPsForEvent(event, null, null);
//        Set<String> userIPs = logParser.getIPsForUser(event, null, new Date());
        userIPs.stream().forEach(System.out::println);
    }

    private static void testGetIPsForStatus(LogParser logParser) {
        System.out.println("\n======================================================================================");
        System.out.print("testGetIPsForStatus");

        Status status = Status.OK;
//        Status status = Status.ERROR;
//        Status status = Status.FAILED;
        System.out.println(": " + status.name());

        Set<String> userIPs = logParser.getIPsForStatus(status, null, null);
//        Set<String> userIPs = logParser.getIPsForUser(status, null, new Date());
        userIPs.stream().forEach(System.out::println);
    }
}
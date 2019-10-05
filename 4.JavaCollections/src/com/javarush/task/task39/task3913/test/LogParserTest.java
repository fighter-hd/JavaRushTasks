package com.javarush.task.task39.task3913.test;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.LogParser;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.javarush.task.task39.task3913.Status;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogParserTest {
    LogParser logParser = new LogParser(Paths.get("C:\\Users\\Gans\\Desktop\\Java_instructions\\For_Tests"));

    @Test
    public void initTest() {
        for (LogParser.LogEntry logEntry : logParser.getLogEntries()) {
            assertNotNull("Parse IP have problems.", logEntry.getIp());
            assertNotNull("Parse UserName have problems.", logEntry.getUser());
            assertNotSame("Parse Date have problems.", -1L, logEntry.getDate());
            assertNotNull("Parse Event have problems.", logEntry.getEvent());
            assertNotNull("Parse Status have problems.", logEntry.getStatus());
//            System.out.println(logEntry);
        }
    }

    @Test
    public void getLogEntriesInGivenPeriodOfTimeTest() {
        List<LogParser.LogEntry> actual = logParser.getLogEntriesInGivenPeriodOfTime(null, null);
        List<LogParser.LogEntry> expected = new ArrayList<>();

        for (LogParser.LogEntry logEntry : logParser.getLogEntries()) {
            expected.add(logEntry);
        }

        assertEquals(expected, actual);
    }

    @Test
    public void getSetOfUniqueIPsInGivenPeriodOfTimeTest() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.08.2012 16:08:40");
            finish = format.parse("12.12.2013 21:56:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual = logParser.getSetOfUniqueIPsInGivenPeriodOfTime(start, finish);

        Set<String> expected = new HashSet<>();
        expected.add("192.168.100.2");
        expected.add("146.34.15.5");
        expected.add("127.0.0.1");

        assertEquals(expected, actual);
    }

    @Test
    public void getAllUsersInGivenPeriodOfTimeTest() {
        Set<String> actual = logParser.getAllUsersInGivenPeriodOfTime(null, null);
        Set<String> expected = new HashSet<>();

        for (LogParser.LogEntry logEntry : logParser.getLogEntries()) {
            expected.add(logEntry.getUser());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfUniqueIPsTest() {
        List<Integer> actual = new ArrayList<>();

        actual.add(logParser.getNumberOfUniqueIPs(null, new Date()));  // 3
        actual.add(logParser.getNumberOfUniqueIPs(new Date(), null));  // 4

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        try {
            start = format.parse("30.08.2012 16:08:40");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        actual.add(logParser.getNumberOfUniqueIPs(start, null)); // 5

        List<Integer> expected = Arrays.asList(3, 4, 5);

        assertEquals(expected, actual);
    }

    @Test
    public void getUniqueIPsTest() {
        Set<String> actual1 = logParser.getUniqueIPs(null, null);

        Set<String> expected1 = new HashSet<>();
        expected1.add("120.120.120.122");
        expected1.add("146.34.15.5");
        expected1.add("192.168.100.2");
        expected1.add("12.12.12.12");
        expected1.add("127.0.0.1");

        assertEquals(expected1, actual1);

       Set<String> actual2 = logParser.getUniqueIPs(null, new Date());

        Set<String> expected2 = new HashSet<>();
        expected2.add("146.34.15.5");
        expected2.add("192.168.100.2");
        expected2.add("127.0.0.1");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getIPsForEventTest() {
        Event event1 = Event.LOGIN;
        Set<String> actual1 = logParser.getIPsForEvent(event1, null, null);
        Set<String> expected1 = new HashSet<>();
        expected1.add("146.34.15.5");
        expected1.add("127.0.0.1");

        assertEquals(expected1, actual1);

        Event event2 = Event.SOLVE_TASK;
        Set<String> actual2 = logParser.getIPsForEvent(event2, null, new Date());
        Set<String> expected2 = new HashSet<>();
        expected2.add("192.168.100.2");

        assertEquals(expected2, actual2);
//        Event event3 = Event.SOLVE_TASK;
    }

    @Test
    public void getIPsForUserTest() {
        String user = "Vasya Pupkin";

        Set<String> actual1 = logParser.getIPsForUser(user, null, null);
        Set<String> expected1 = new HashSet<>();
        expected1.add("192.168.100.2");
        expected1.add("127.0.0.1");

        assertEquals(expected1, actual1);

        Set<String> actual2 = logParser.getIPsForUser(user, null, new Date());
        assertEquals(expected1, actual2);
    }

    @Test
    public void getIPsForStatusTest() {
        Status status1 = Status.OK;
        Set<String> actual1 = logParser.getIPsForStatus(status1, null, null);
        Set<String> expected1 = new HashSet<>();
        expected1.add("120.120.120.122");
        expected1.add("146.34.15.5");
        expected1.add("192.168.100.2");
        expected1.add("12.12.12.12");
        expected1.add("127.0.0.1");

        assertEquals(expected1, actual1);

        Status status2 = Status.FAILED;
        Set<String> actual2 = logParser.getIPsForStatus(status2, null, new Date());
        Set<String> expected2 = new HashSet<>();
        expected2.add("127.0.0.1");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getAllUsersTest() {
        Set<String> actual = logParser.getAllUsers();

        Set<String> expected = new HashSet<>();
        expected.add("Amigo");
        expected.add("Vasya Pupkin");
        expected.add("Eduard Petrovich Morozko");

        assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfUsersTest() {
        int actual = logParser.getNumberOfUsers(null, null);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfUserEventsTest() {
        String user1 = "Eduard Petrovich Morozko";
        int actual1 = logParser.getNumberOfUserEvents(user1, null, null);
        int expected1 = 4;
        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.01.2014 12:56:22");
            finish = format.parse("19.03.2016 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String user2 = "Vasya Pupkin";
        int actual2 = logParser.getNumberOfUserEvents(user2, start, finish);
        int expected2 = 2;
        assertEquals(expected2, actual2);
    }

    @Test
    public void getUsersForIPTest() {
        String ip = "127.0.0.1";
        Set<String> actual1 = logParser.getUsersForIP(ip, null, null);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Vasya Pupkin");
        expected1.add("Amigo");
        expected1.add("Eduard Petrovich Morozko");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("11.12.2013 10:11:12");
            finish = format.parse("14.11.2015 07:08:01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getUsersForIP(ip, start, finish);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Vasya Pupkin");
        expected2.add("Eduard Petrovich Morozko");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getLoggedUsersTest() {
        Set<String> actual1 = logParser.getLoggedUsers(null, null);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Amigo");
        expected1.add("Vasya Pupkin");
        expected1.add("Eduard Petrovich Morozko");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date finish = null;
        try {
            finish = format.parse("14.11.2015 07:08:01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getLoggedUsers(null, finish);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Amigo");
        expected2.add("Eduard Petrovich Morozko");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDownloadedPluginUsersTest() {
        Set<String> actual1 = logParser.getDownloadedPluginUsers(null, null);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Eduard Petrovich Morozko");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("17.11.2010 10:11:12");
            finish = format.parse("13.09.2013 5:04:50");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getDownloadedPluginUsers(start, finish);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Eduard Petrovich Morozko");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getWroteMessageUsersTest() {
        Set<String> actual1 = logParser.getWroteMessageUsers(null, null);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Amigo");
        expected1.add("Vasya Pupkin");
        expected1.add("Eduard Petrovich Morozko");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("11.12.2013 10:11:12");
            finish = format.parse("12.12.2013 21:56:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getWroteMessageUsers(start, finish);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Eduard Petrovich Morozko");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getSolvedTaskUsersTest() {
        Set<String> actual1 = logParser.getSolvedTaskUsers(null, null);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Amigo");
        expected1.add("Vasya Pupkin");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.01.2014 12:56:22");
            finish = format.parse("30.01.2014 12:56:22");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getSolvedTaskUsers(start, finish);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Vasya Pupkin");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getSolvedTaskUsersWithCountTest() {
        int taskNumber = 18;
        Set<String> actual1 = logParser.getSolvedTaskUsers(null, null, taskNumber);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Amigo");
        expected1.add("Vasya Pupkin");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("19.03.2016 00:00:00");
            finish = format.parse("29.2.2028 5:4:7");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getSolvedTaskUsers(start, finish, taskNumber);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Amigo");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDoneTaskUsersTest() {
        Set<String> actual1 = logParser.getDoneTaskUsers(null, null);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Vasya Pupkin");
        expected1.add("Eduard Petrovich Morozko");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("05.01.2021 20:22:55");
            finish = format.parse("05.01.2021 20:22:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getDoneTaskUsers(start, finish);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Eduard Petrovich Morozko");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDoneTaskUsersWithCountTest() {
        int taskNumber = 48;
        Set<String> actual1 = logParser.getDoneTaskUsers(null, null, taskNumber);

        Set<String> expected1 = new HashSet<>();
        expected1.add("Eduard Petrovich Morozko");

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("05.01.2021 20:22:55");
            finish = format.parse("05.01.2021 20:22:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<String> actual2 = logParser.getDoneTaskUsers(start, finish, taskNumber);

        Set<String> expected2 = new HashSet<>();
        expected2.add("Eduard Petrovich Morozko");

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDatesForUserAndEventTest() {
        String user = "Eduard Petrovich Morozko";
        Event event = Event.WRITE_MESSAGE;
        Set<Date> actual1 = logParser.getDatesForUserAndEvent(user, event, null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date11 = null;
        Date date12 = null;
        try {
            date11 = format.parse("11.12.2013 10:11:12");
            date12 = format.parse("12.12.2013 21:56:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> expected1 = new HashSet<>();
        expected1.add(date11);
        expected1.add(date12);

        assertEquals(expected1, actual1);

        Date start = null;
        Date finish = null;
        try {
            start = format.parse("12.12.2013 21:00:00");
            finish = format.parse("12.12.2013 22:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> actual2 = logParser.getDatesForUserAndEvent(user, event, start, finish);
        Set<Date> expected2 = new HashSet<>();
        expected2.add(date12);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDatesWhenSomethingFailedTest() {
        Set<Date> actual1 = logParser.getDatesWhenSomethingFailed(null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date11 = null;
        Date date12 = null;
        Date date13 = null;
        try {
            date11 = format.parse("11.12.2013 10:11:12");
            date12 = format.parse("01.01.2025 00:00:00");
            date13 = format.parse("05.01.2021 20:22:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> expected1 = new HashSet<>();
        expected1.add(date11);
        expected1.add(date12);
        expected1.add(date13);

        assertEquals(expected1, actual1);

        Date start = null;
        Date finish = null;
        try {
            start = format.parse("05.01.2021 20:00:00");
            finish = format.parse("05.01.2021 22:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> actual2 = logParser.getDatesWhenSomethingFailed(start, finish);
        Set<Date> expected2 = new HashSet<>();
        expected2.add(date13);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDatesWhenErrorHappenedTest() {
        Set<Date> actual1 = logParser.getDatesWhenErrorHappened(null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date11 = null;
        Date date12 = null;
        try {
            date11 = format.parse("30.01.2014 12:56:22");
            date12 = format.parse("21.10.2030 01:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> expected1 = new HashSet<>();
        expected1.add(date11);
        expected1.add(date12);

        assertEquals(expected1, actual1);

        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.01.2014 12:00:00");
            finish = format.parse("30.01.2014 14:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> actual2 = logParser.getDatesWhenErrorHappened(start, finish);
        Set<Date> expected2 = new HashSet<>();
        expected2.add(date11);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDateWhenUserLoggedFirstTimeTest() {
        String user1 = "Vasya Pupkin";
        Date actual1 = logParser.getDateWhenUserLoggedFirstTime(user1, null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date expected1 = null;
        try {
            expected1 = format.parse("14.10.2021 11:38:21");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals(expected1, actual1);

        String user2 = "Eduard Petrovich Morozko";
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("03.01.2014 04:00:00");
            finish = format.parse("03.01.2014 05:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date actual2 = logParser.getDateWhenUserLoggedFirstTime(user2, start, finish);

        assertNull(actual2);
    }

    @Test
    public void getDateWhenUserSolvedTaskTest() {
        String user1 = "Amigo";
        int task1 = 18;
        Date actual1 = logParser.getDateWhenUserSolvedTask(user1, task1, null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date expected1 = null;
        try {
            expected1 = format.parse("21.10.2021 19:45:25");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals(expected1, actual1);

        String user2 = "Eduard Petrovich Morozko";
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("19.03.2016 00:00:00");
            finish = format.parse("14.10.2021 11:38:21");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int task2 = 48;
        Date actual2 = logParser.getDateWhenUserSolvedTask(user2, task2, start, finish);

        assertNull(actual2);
    }

    @Test
    public void getDateWhenUserDoneTaskTest() {
        String user1 = "Eduard Petrovich Morozko";
        int task1 = 48;
        Date actual1 = logParser.getDateWhenUserDoneTask(user1, task1, null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date expected1 = null;
        try {
            expected1 = format.parse("05.01.2021 20:22:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals(expected1, actual1);

        String user2 = "Vasya Pupkin";
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("10.01.2013 00:00:00");
            finish = format.parse("14.10.2021 11:38:21");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int task2 = 15;
        Date actual2 = logParser.getDateWhenUserDoneTask(user2, task2, start, finish);

        assertNull(actual2);
    }

    @Test
    public void getDatesWhenUserWroteMessageTest() {
        String user1 = "Eduard Petrovich Morozko";
        Set<Date> actual1 = logParser.getDatesWhenUserWroteMessage(user1, null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date11 = null;
        Date date12 = null;
        try {
            date11 = format.parse("11.12.2013 10:11:12");
            date12 = format.parse("12.12.2013 21:56:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> expected1 = new HashSet<>();
        expected1.add(date11);
        expected1.add(date12);

        assertEquals(expected1, actual1);

        Date start = null;
        Date finish = null;
        try {
            start = format.parse("05.01.2021 20:00:00");
            finish = format.parse("05.01.2021 22:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String user2 = "Amigo";
        Set<Date> actual2 = logParser.getDatesWhenUserWroteMessage(user2, start, finish);
        Set<Date> expected2 = new HashSet<>();

        assertEquals(expected2, actual2);
    }

    @Test
    public void getDatesWhenUserDownloadedPluginTest() {
        String user1 = "Eduard Petrovich Morozko";
        Set<Date> actual1 = logParser.getDatesWhenUserDownloadedPlugin(user1, null, null);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date11 = null;
        try {
            date11 = format.parse("13.09.2013 5:04:50");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Date> expected1 = new HashSet<>();
        expected1.add(date11);

        assertEquals(expected1, actual1);

        Date start = null;
        Date finish = null;
        try {
            start = format.parse("05.01.2021 20:00:00");
            finish = format.parse("05.01.2021 22:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String user2 = "Amigo";
        Set<Date> actual2 = logParser.getDatesWhenUserDownloadedPlugin(user2, start, finish);
        Set<Date> expected2 = new HashSet<>();

        assertEquals(expected2, actual2);
    }

    @Test
    public void getNumberOfAllEventsTest() {
        int actual1 = logParser.getNumberOfAllEvents(null, null);
        int expected1 = 5;

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("12.12.2013 21:56:30");
            finish = format.parse("14.11.2015 07:08:01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int actual2 = logParser.getNumberOfAllEvents(start, finish);
        int expected2 = 3;

        assertEquals(expected2, actual2);
    }

    @Test
    public void getAllEventsTest() {
        Set<Event> actual1 = logParser.getAllEvents(null, null);
        Set<Event> expected1 = new HashSet<>();
        expected1.add(Event.LOGIN);
        expected1.add(Event.DONE_TASK);
        expected1.add(Event.DOWNLOAD_PLUGIN);
        expected1.add(Event.WRITE_MESSAGE);
        expected1.add(Event.SOLVE_TASK);

        assertEquals(expected1, actual1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("12.12.2013 21:56:30");
            finish = format.parse("14.11.2015 07:08:01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Event> actual2 = logParser.getAllEvents(start, finish);
        Set<Event> expected2 = new HashSet<>();
        expected2.add(Event.LOGIN);
        expected2.add(Event.WRITE_MESSAGE);
        expected2.add(Event.SOLVE_TASK);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getEventsForIPTest() {
        String ip1 = "192.168.100.2";
        Set<Event> actual1 = logParser.getEventsForIP(ip1, null, null);
        Set<Event> expected1 = new HashSet<>();
        expected1.add(Event.DONE_TASK);
        expected1.add(Event.SOLVE_TASK);

        assertEquals(expected1, actual1);

        String ip2 = "127.0.0.1";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.01.2014 12:56:22");
            finish = format.parse("14.10.2021 11:38:21");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Event> actual2 = logParser.getEventsForIP(ip2, start, finish);
        Set<Event> expected2 = new HashSet<>();
        expected2.add(Event.LOGIN);
        expected2.add(Event.WRITE_MESSAGE);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getEventsForUserTest() {
        String user1 = "Eduard Petrovich Morozko";
        Set<Event> actual1 = logParser.getEventsForUser(user1, null, null);
        Set<Event> expected1 = new HashSet<>();
        expected1.add(Event.LOGIN);
        expected1.add(Event.DOWNLOAD_PLUGIN);
        expected1.add(Event.DONE_TASK);
        expected1.add(Event.WRITE_MESSAGE);

        assertEquals(expected1, actual1);

        String user2 = "Amigo";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.08.2012 16:08:13");
            finish = format.parse("21.10.2021 19:45:25");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Event> actual2 = logParser.getEventsForUser(user2, start, finish);
        Set<Event> expected2 = new HashSet<>();
        expected2.add(Event.LOGIN);
        expected2.add(Event.SOLVE_TASK);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getFailedEventsTest() {
        Set<Event> actual1 = logParser.getFailedEvents(null, null);
        Set<Event> expected1 = new HashSet<>();
        expected1.add(Event.DONE_TASK);
        expected1.add(Event.WRITE_MESSAGE);

        assertEquals(expected1, actual1);

        String user2 = "Amigo";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("05.01.2021 20:22:55");
            finish = format.parse("01.01.2025 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Event> actual2 = logParser.getFailedEvents(start, finish);
        Set<Event> expected2 = new HashSet<>();
        expected2.add(Event.DONE_TASK);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getErrorEventsTest() {
        Set<Event> actual1 = logParser.getErrorEvents(null, null);
        Set<Event> expected1 = new HashSet<>();
        expected1.add(Event.SOLVE_TASK);
        expected1.add(Event.WRITE_MESSAGE);

        assertEquals(expected1, actual1);

        String user2 = "Amigo";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("03.01.2014 03:45:23");
            finish = format.parse("14.11.2015 07:08:01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Event> actual2 = logParser.getErrorEvents(start, finish);
        Set<Event> expected2 = new HashSet<>();
        expected2.add(Event.SOLVE_TASK);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getNumberOfAttemptToSolveTaskTest() {
        int task1 = 48;
        int actual1 = logParser.getNumberOfAttemptToSolveTask(task1,null, null);
        int expected1 = 0;

        assertEquals(expected1, actual1);

        int task2 = 18;
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("21.10.2021 19:45:25");
            finish = format.parse("29.2.2028 5:4:7");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int actual2 = logParser.getNumberOfAttemptToSolveTask(task2, start, finish);
        int expected2 = 2;

        assertEquals(expected2, actual2);
    }

    @Test
    public void getNumberOfSuccessfulAttemptToSolveTaskTest() {
        int task1 = 48;
        int actual1 = logParser.getNumberOfSuccessfulAttemptToSolveTask(task1,null, null);
        int expected1 = 2;

        assertEquals(expected1, actual1);

        int task2 = 15;
        int actual2 = logParser.getNumberOfSuccessfulAttemptToSolveTask(task2, null, null);
        int expected2 = 1;

        assertEquals(expected2, actual2);
    }

    @Test
    public void getAllSolvedTasksAndTheirNumberTest() {
        Map<Integer, Integer> actual1 = logParser.getAllSolvedTasksAndTheirNumber(null, null);
        Map<Integer, Integer> expected1 = new HashMap<>();
        expected1.put(1, 1);
        expected1.put(18, 3);

        assertEquals(expected1, actual1);

        String user2 = "Amigo";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.08.2012 16:08:40");
            finish = format.parse("30.01.2014 12:56:22");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<Integer, Integer> actual2 = logParser.getAllSolvedTasksAndTheirNumber(start, finish);
        Map<Integer, Integer> expected2 = new HashMap<>();
        expected2.put(18, 1);

        assertEquals(expected2, actual2);
    }

    @Test
    public void getAllDoneTasksAndTheirNumberTest() {
        Map<Integer, Integer> actual1 = logParser.getAllDoneTasksAndTheirNumber(null, null);
        Map<Integer, Integer> expected1 = new HashMap<>();
        expected1.put(15, 1);
        expected1.put(48, 2);

        assertEquals(expected1, actual1);

        String user2 = "Amigo";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        Date finish = null;
        try {
            start = format.parse("30.08.2012 16:08:40");
            finish = format.parse("05.01.2021 20:22:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<Integer, Integer> actual2 = logParser.getAllDoneTasksAndTheirNumber(start, finish);
        Map<Integer, Integer> expected2 = new HashMap<>();
        expected2.put(15, 1);
        expected2.put(48, 1);

        assertEquals(expected2, actual2);
    }

    @Test
    public void executeTest() {
        Set<Object> actual1 = logParser.execute("get ip");
        Set<Object> expected1 = new HashSet<>();
        expected1.add("127.0.0.1");
        expected1.add("12.12.12.12");
        expected1.add("146.34.15.5");
        expected1.add("192.168.100.2");
        expected1.add("120.120.120.122");
        assertEquals(expected1, actual1);


        Set<Object> actual2 = logParser.execute("get user");
        Set<Object> expected2 = new HashSet<>();
        expected2.add("Amigo");
        expected2.add("Vasya Pupkin");
        expected2.add("Eduard Petrovich Morozko");
        assertEquals(expected2, actual2);


        Set<Object> actual3 = logParser.execute("get date");
        Set<Object> expected3 = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            expected3.add(format.parse("30.08.2012 16:08:13"));
            expected3.add(format.parse("30.08.2012 16:08:40"));
            expected3.add(format.parse("13.09.2013 5:04:50"));
            expected3.add(format.parse("11.12.2013 10:11:12"));
            expected3.add(format.parse("12.12.2013 21:56:30"));
            expected3.add(format.parse("03.01.2014 03:45:23"));
            expected3.add(format.parse("21.10.2030 01:00:00"));
            expected3.add(format.parse("30.01.2014 12:56:22"));
            expected3.add(format.parse("14.11.2015 07:08:01"));
            expected3.add(format.parse("01.01.2025 00:00:00"));
            expected3.add(format.parse("21.10.2030 00:00:00"));
            expected3.add(format.parse("19.03.2016 00:00:00"));
            expected3.add(format.parse("05.01.2021 20:22:55"));
            expected3.add(format.parse("14.10.2021 11:38:21"));
            expected3.add(format.parse("21.10.2021 19:45:25"));
            expected3.add(format.parse("29.2.2028 5:4:7"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(expected3, actual3);

        Set<Object> actual4 = logParser.execute("get event");
        Set<Object> expected4 = new HashSet<>();
        expected4.add(Event.LOGIN);
        expected4.add(Event.DOWNLOAD_PLUGIN);
        expected4.add(Event.WRITE_MESSAGE);
        expected4.add(Event.SOLVE_TASK);
        expected4.add(Event.DONE_TASK);
        assertEquals(expected4, actual4);


        Set<Object> actual5 = logParser.execute("get status");
        Set<Object> expected5 = new HashSet<>();
        expected5.add(Status.OK);
        expected5.add(Status.FAILED);
        expected5.add(Status.ERROR);
        assertEquals(expected5, actual5);
    }
}
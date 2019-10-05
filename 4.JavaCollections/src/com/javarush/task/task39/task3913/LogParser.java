package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery, UserQuery {
    private List<File> logFiles;
    private List<LogEntry> logEntries;

    public LogParser(Path logDir) {
        this.logFiles = getAllLogFiles(logDir);
        this.logEntries = getAllLogsEntries(this.logFiles);
    }

    private static List<File> getAllLogFiles(Path logDir) {
        List<File> files = new ArrayList<>();

        try (Stream<Path> paths = Files.list(logDir)) {

            paths.filter(Files::isRegularFile)
                    .filter(e -> e.toString().endsWith(".log"))
                    .forEach(e -> files.add(e.toFile()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return files;
    }

    private List<LogEntry> getAllLogsEntries(List<File> logs) {
        List<LogEntry> allEntries = new ArrayList<>();

        for (File log : logs) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log)))) {

                List<String> allCurrentLogEntries = reader.lines().collect(Collectors.toList());

                for (String currentLine : allCurrentLogEntries) {
                    String[] lineData = currentLine.split("\t");
                    allEntries.add(new LogEntry(lineData));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return allEntries;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> uniqueIp = getSetOfUniqueIPsInGivenPeriodOfTime(after, before);
        return uniqueIp.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getSetOfUniqueIPsInGivenPeriodOfTime(after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user))
                .collect(
                        () -> new HashSet<>(),
                        (set, item) -> set.add(item.getIp()),
                        (set1, set2) -> set1.addAll(set2));
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(event))
                .collect(
                        () -> new HashSet<>(),
                        (set, item) -> set.add(item.getIp()),
                        (set1, set2) -> set1.addAll(set2));
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getStatus().equals(status))
                .collect(
                        () -> new HashSet<>(),
                        (set, item) -> set.add(item.getIp()),
                        (set1, set2) -> set1.addAll(set2));
    }

    public Set<String> getSetOfUniqueIPsInGivenPeriodOfTime(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before).stream()
                .collect(
                        () -> new HashSet<>(),
                        (set, item) -> set.add(item.getIp()),
                        (set1, set2) -> set1.addAll(set2));
    }

    public List<LogEntry> getLogEntriesInGivenPeriodOfTime(Date after, Date before) {
        Long longAfter = getAfterLongDate(after);
        Long longBefore = getBeforeLongDate(before);

        return logEntries.stream().filter(e -> e.getDate() >= longAfter && e.getDate() <= longBefore)
                .collect(
                        () -> new ArrayList<>(),
                        (list, item) -> list.add(item),
                        (list1, list2) -> list1.addAll(list2));
    }

    public Set<String> getAllUsersInGivenPeriodOfTime(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    private static Long getAfterLongDate(Date after) {
        Long longAfter;
        if (after == null) {
            longAfter = Long.MIN_VALUE;
        } else {
            longAfter = after.getTime();
        }

        return longAfter;
    }

    private static Long getBeforeLongDate(Date before) {
        Long longBefore;
        if (before == null) {
            longBefore = Long.MAX_VALUE;
        } else {
            longBefore = before.getTime();
        }

        return longBefore;
    }

    public List<File> getLogFiles() {
        return logFiles;
    }

    public List<LogEntry> getLogEntries() {
        return logEntries;
    }

    @Override
    public Set<String> getAllUsers() {
        return getLogEntries().stream()
                                .collect(
                                        () -> new HashSet<>(),
                                        (list, item) -> list.add(item.getUser()),
                                        (list1, list2) -> list1.addAll(list2));
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return (int) getAllUsersInGivenPeriodOfTime(after, before).stream().count();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> uniqueEventsForCurrentUser = getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user))
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getEvent()),
                        (set1, set2)->set1.addAll(set2));

        return uniqueEventsForCurrentUser.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getIp().equals(ip))
                .collect(
                    ()->new HashSet<>(),
                    (set, item)->set.add(item.getUser()),
                    (set1, set2)->set1.addAll(set2));
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.LOGIN))
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.WRITE_MESSAGE))
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.SOLVE_TASK))
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.SOLVE_TASK))
                .filter(e -> e.getTaskNumber() == task)
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DONE_TASK))
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DONE_TASK))
                .filter(e -> e.getTaskNumber() == task)
                .collect(
                        ()->new HashSet<>(),
                        (set, item)->set.add(item.getUser()),
                        (set1, set2)->set1.addAll(set2));
    }

    public class LogEntry {
        String ip;
        String user;
        Long date;
        Event event;
        Integer taskNumber;
        Status status;

        public LogEntry(String ip, String user, String date, String event, String status) {
            this.ip = ip;
            this.user = user;
            this.date = parseDate(date);
            this.event = parseEvent(event);
            this.status = parseStatus(status);
        }

        public LogEntry(String[] data) {
            this(data[0], data[1], data[2], data[3], data[4]);
        }

        private Long parseDate(String string) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            Date date = null;

            try {
                date = dateFormat.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return date != null ? date.getTime() : -1L;
        }

        private Event parseEvent(String string) {
            if (string.contains("LOGIN")) {
                return Event.LOGIN;
            }

            if (string.contains("DOWNLOAD_PLUGIN")) {
                return Event.DOWNLOAD_PLUGIN;
            }

            if (string.contains("WRITE_MESSAGE")) {
                return Event.WRITE_MESSAGE;
            }

            if (string.contains("SOLVE_TASK")) {
                this.taskNumber = getTaskNumber(string);
                return Event.SOLVE_TASK;
            }

            if (string.contains("DONE_TASK")) {
                this.taskNumber = getTaskNumber(string);
                return Event.DONE_TASK;
            }

            return null;
        }

        private Integer getTaskNumber(String event) {
            Integer result = null;

            String[] array = event.split(" ");

            if (array.length > 1) {
                result = Integer.parseInt(array[1]);
            }

            return result;
        }

        private Status parseStatus(String string) {
            switch (string) {
                case "OK":
                    return Status.OK;
                case "FAILED":
                    return Status.FAILED;
                case "ERROR":
                    return Status.ERROR;
            }

            return null;
        }

        public String getIp() {
            return ip;
        }

        public String getUser() {
            return user;
        }

        public Long getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public Integer getTaskNumber() {
            return taskNumber;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "ip='" + ip + '\'' +
                    ", user='" + user + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", status=" + status +
                    '}';
        }
    }
}
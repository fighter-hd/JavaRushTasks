package com.javarush.task.task39.task3913.test;

import com.javarush.task.task39.task3913.LogParser;
import java.nio.file.Paths;

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
            System.out.println(logEntry);
        }
    }
}
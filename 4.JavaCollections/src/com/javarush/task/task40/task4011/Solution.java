package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) throws MalformedURLException {
        try {
            URL url = new URL(s);
            StringBuilder builder = new StringBuilder();
            builder.append("- ").append(url.getProtocol()).append("\n");
            builder.append("- ").append(url.getAuthority()).append("\n");
            builder.append("- ").append(url.getFile()).append("\n");
            builder.append("- ").append(url.getHost()).append("\n");
            builder.append("- ").append(url.getPath()).append("\n");
            builder.append("- ").append(url.getPort()).append("\n");
            builder.append("- ").append(url.getDefaultPort()).append("\n");
            builder.append("- ").append(url.getQuery()).append("\n");
            builder.append("- ").append(url.getRef());

            System.out.println(builder.toString());

        } catch (MalformedURLException e) {
            System.out.println("Parameter " + s + " is not a valid URL.");
        }
    }
}


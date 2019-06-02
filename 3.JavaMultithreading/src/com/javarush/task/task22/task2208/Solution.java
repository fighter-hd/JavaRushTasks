package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                builder.append(entry.getKey());
                builder.append(" = \'");
                builder.append(entry.getValue());
                builder.append("\'");
                builder.append(" and ");
            }
        }

        String result = builder.toString();

        if (result.length() < 1) {
            return "";
        } else {
            return result.substring(0, result.length() - 5);
        }
    }
}

package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);

        System.out.print(s.getClass().getSimpleName());
        System.out.println(": " + s);
        System.out.print(f.getClass().getSimpleName());
        System.out.println(": " + f);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        mapper.writeValue(writer, one);

        StringReader reader = new StringReader(writer.toString());
        Object two = mapper.readValue(reader, resultClassObject);

        return two;

//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(one);
//
//        jsonString = jsonString.replace(one.getClass().getSimpleName().toLowerCase(), resultClassObject.getSimpleName().toLowerCase());
//
//        StringReader reader = new StringReader(jsonString);
//        Object two = mapper.readValue(reader, resultClassObject);
//
//        return two;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int number = 1;
        public String name = "one";

        @Override
        public String toString() {
            return "Name - " + name + ", number - " + number;
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int number = 2;
        public String name = "two";

        @Override
        public String toString() {
            return "Name - " + name + ", number - " + number;
        }
    }
}

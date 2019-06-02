package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        String result = "Животное";

        if (o instanceof Cat) {
            result = "Кот";
        } else if (o instanceof Tiger) {
            result = "Тигр";
        } else if (o instanceof Lion) {
            result = "Лев";
        } else if (o instanceof Bull) {
            result = "Бык";
        }

        return result;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}

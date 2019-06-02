package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        new Zerg().name = "zerg1";
        new Zerg().name = "zerg2";
        new Zerg().name = "zerg3";
        new Zerg().name = "zerg4";
        new Zerg().name = "zerg5";

        new Protoss().name = "protoss1";
        new Protoss().name = "protoss2";
        new Protoss().name = "protoss3";

        new Terran().name = "terran1";
        new Terran().name = "terran2";
        new Terran().name = "terran3";
        new Terran().name = "terran4";

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}

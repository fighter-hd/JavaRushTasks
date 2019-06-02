package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Vanya", 50, "Lyuk");
        Man man2 = new Man("Sanya", 54, "Pod`ezd");
        Woman woman1 = new Woman("Lena", 60, "Pod`ezd");
        Woman woman2 = new Woman("Vera", 48, "Street");

        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(woman1.toString());
        System.out.println(woman2.toString());
    }

    public static class Man {
        private String name;
        private int age;
        private String address;

        public Man() {
            this.name = "No name";
            this.age = 35;
            this.address = "street";
        }

        public Man(String name) {
            this.name = name;
            this.age = 35;
            this.address = "street";
        }

        public Man(String name, int age) {
            this.name = name;
            if (age > 0) {
                this.age = age;
            }
            this.address = "street";
        }

        public Man(String name, int age, String address) {
            this.name = name;
            if (age > 0) {
                this.age = age;
            }
            this.address = address;
        }

        public String toString() {
            String s = name + " " + age + " " + address;
            return s;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age > 0) {
                this.age = age;
            }
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman() {
            this.name = "No name";
            this.age = 35;
            this.address = "street";
        }

        public Woman(String name) {
            this.name = name;
            this.age = 35;
            this.address = "street";
        }

        public Woman(String name, int age) {
            this.name = name;
            if (age > 0) {
                this.age = age;
            }
            this.address = "street";
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            if (age > 0) {
                this.age = age;
            }
            this.address = address;
        }

        public String toString() {
            String s = name + " " + age + " " + address;
            return s;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age > 0) {
                this.age = age;
            }
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}

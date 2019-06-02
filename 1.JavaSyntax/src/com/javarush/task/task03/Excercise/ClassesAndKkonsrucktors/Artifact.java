package com.javarush.task.Excercise.ClassesAndKkonsrucktors;

/* Музей древностей.

    Твоя задача — спроектировать класс Artifact.
    Артефакты, которые хранятся в музее, бывают трех видов.
    Первый — про которые неизвестно ничего, кроме порядкового номера, присвоенному музеем (например: 212121).
    Второй — про которые известен порядковый номер и культура, которой он был создан (например: 212121, "Ацтеки").
    Третий вид — про которые известен порядковый номер, культура, которой он был создан, и точный век его создания (например: 212121, "Ацтеки", 12).

    Создай класс Artifact, описывающий хранящиеся в музее древности, и напиши необходимое количество конструкторов для него. В методе main() создай по одному артефакту каждого вида.
*/


public class Artifact {

    int number;
    String culture;
    int centuries;

    public Artifact (int number) {
        this.number = number;
    }

    public Artifact (int number, String culture) {
        this.number = number;
        this.culture = culture;
    }

    public Artifact (int number, String culture, int centuries) {
        this.number = number;
        this.culture =  culture;
        this.centuries = centuries;
    }

    public static void main(String[] args) {
        Artifact one = new Artifact(114342);
        Artifact two = new Artifact(623654, "Hohly");
        Artifact three = new Artifact(236354, "Moskali", 20);
    }
}

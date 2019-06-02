package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import static java.lang.String.valueOf;  //для второго варианта

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

        //создаём массив типа int размером в 3 элемента и присваеваем его переменной "array":
        int[] array = new int[3];

        //создаём цикл for в котором присваиваем поочерёдно каждому "i"-му элементу массива "array" (начиная с
        //последнего (array.length в данном случае равно 3, а крайний элемент данного масива имеет идекс 2, по
        //этому начинать цикл нужно с "int i = array.length - 1;" ) и доходим до первого) ОСТАТОК ОТ ДЕЛЕНИЯ
        //числа "number" на 10 (тоесть 546 % 10 = 6):
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = number % 10;

            //удаляем из числа "number" последнюю цифру ( 546 / 10 = 54,6 , но тип int округляет
            // число до меньшего целого и теперь "number = 54"):
            number = number / 10;
        }

        //сумируем и присваиваем переменной "sum" числа 5, 4 и 6:
        int sum = array[0] + array[1] + array[2];

        //возвращаем переменную "sum" туда где метод был вызван:
        return sum;
    }
}

/*  //преобразовываем параметр метода "number" в строку "s" вызывая метод valueOf(int i):
    String s = valueOf(number);

    //наполняем массив типа char "c" символами из строки "s" с помощью метода toCharArray(). Учитывайте что
    //каждый элемент массива будет представлять собой символ в кодировке ASCII. Например цифра "5" имеет
    //код "53", тоесть первый элемент массива будет содержать "53":
    char[] c = s.toCharArray();

    //присваиваем каждой переменной типа int значение символа из ячейки массива "с", предварительно
    //меняя кодировку ASCII на обычное число (в ячейке "с[0]" сейчас храниться значение "53" которое
    //мы преобразовываем в число "5" с помощью метода getNumericValue(char c) класса Character:
    int num1 = Character.getNumericValue(c[0]);
    int num2 = Character.getNumericValue(c[1]);
    int num3 = Character.getNumericValue(c[2]);

    //сумируем и присваиваем переменной "sum" уже преобразованные в привычный вид числа 5, 4 и 6:
    int sum = num1 + num2 + num3;

    //возвращаем переменную "sum" туда где метод был вызван:
    return sum;
*/

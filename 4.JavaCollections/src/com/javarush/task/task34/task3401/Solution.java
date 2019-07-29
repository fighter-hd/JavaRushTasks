package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        int fibonacciNumber = 1;

        if (n > 1) {
            fibonacciNumber = fibonacci(n - 1);
        }

        int n1 = 1;
        int n2 = 1;

        if (n > 2) {
            for (int i = 0; i < n - 2; i++) {
                fibonacciNumber = n1 + n2;
                n1 = n2;
                n2 = fibonacciNumber;
            }
        }

        return fibonacciNumber;
    }
}

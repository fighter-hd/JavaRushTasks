package com.javarush.task.task20.task2025;

import java.util.*;
import java.util.concurrent.*;

/*
Алгоритмы-числа
*/
public class Solution {
    //массив готовых чисел в степени. Пример:
    // 3 в степени 4 = numbersInDegree[3][4]
    private static long[][] numbersInDegree = new long[11][20];
    private static long numberForCalculations = Long.MAX_VALUE;

    static {
        //инициализация занимает около 40 миллисекунд
        for (int degree = 0; degree <= 19; degree++) {
            numbersInDegree[0][degree] = 0;
        }

        for (int degree = 1; degree <= 19; degree++) {
            numbersInDegree[1][degree] = 1;
        }

        for (int i = 2; i <= 10; i++) {
            long result = 1;

            for (int j = 1; j <= 19; j++) {
                result *= i;
                numbersInDegree[i][j] = result;
            }
        }
    }

    public static long[] getNumbers(long N) {
        Set<Long> resultTreeSet = new TreeSet<>();

        if (N > 0 && N <= Long.MAX_VALUE) {

            if (N < 10) {
                long[] numArray = new long[(int) N - 1];

                for (int i = 0; i < numArray.length; i++) {
                    numArray[i] = i + 1;
                }

                return numArray;

            } else {
                for (long i = 1; i < 10; i++) {
                    resultTreeSet.add(i);
                }
            }

            Callable<Set<Long>> callable1 = () -> {
                Set<Long> set = new HashSet<>();

                for (long i = 10; i < N / 3; i = getNextNumber(i)) {
                    long temp = isArmstrongNumber(i);

                    if (temp > 0 && temp < N) {
                        set.add(temp);
                    }
                }

                return set;
            };

            Callable<Set<Long>> callable2 = new Callable<Set<Long>>() {
                @Override
                public Set<Long> call() throws Exception {
                    Set<Long> set = new HashSet<>();

                    for (long i = N / 3 + 1; i < N / 3 * 2; i = getNextNumber(i)) {
                        long temp = isArmstrongNumber(i);

                        if (temp > 0 && temp < N) {
                            set.add(temp);
                        }
                    }

                    return set;
                }
            };

            Callable<Set<Long>> callable3 = () -> {
                Set<Long> set = new HashSet<>();

                for (long i = N / 3 * 2 + 1; i < N; i = getNextNumber(i)) {
                    long temp = isArmstrongNumber(i);

                    if (temp > 0 && temp < N) {
                        set.add(temp);
                    }
                }

                return set;
            };

            Callable<Set<Long>> callable4 = () -> {
                Set<Long> set = new HashSet<>();

                for (long i = 10; i < N / 2; i = getDividedByTen(i)) {
                    long temp = isArmstrongNumber(i);

                    if (temp > 0 && temp < N) {
                        set.add(temp);
                    }
                }

                return set;
            };

            Callable<Set<Long>> callable5 = () -> {
                Set<Long> set = new HashSet<>();

                for (long i = N / 2 + 1; i < N; i = getDividedByTen(i)) {
                    long temp = isArmstrongNumber(i);

                    if (temp > 0 && temp < N) {
                        set.add(temp);
                    }
                }

                return set;
            };

            Callable<Set<Long>> callable6 = () -> {
                Set<Long> set = new HashSet<>();

                for (long i = 100; i < N; i = getHundredRankNumbers(i)) {
                    long temp = isArmstrongNumber(i);

                    if (temp > 0 && temp < N) {
                        set.add(temp);
                    }
                }

                return set;
            };

            Callable<Set<Long>> callable7 = () -> {
                Set<Long> set = new HashSet<>();

                for (long i = 1000; i < N; i = getThousandthNumbers(i)) {
                    long temp = isArmstrongNumber(i);

                    if (temp > 0 && temp < N) {
                        set.add(temp);
                    }
                }

                return set;
            };

            ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);

            Future<Set<Long>> future1 = threadPool.submit(callable1);
            Future<Set<Long>> future2 = threadPool.submit(callable2);
            Future<Set<Long>> future3 = threadPool.submit(callable3);
            Future<Set<Long>> future4 = threadPool.submit(callable4);
            Future<Set<Long>> future5 = threadPool.submit(callable5);
            Future<Set<Long>> future6 = threadPool.submit(callable6);
            Future<Set<Long>> future7 = threadPool.submit(callable7);

            threadPool.shutdown();

            Set<Long> set1 = null;
            Set<Long> set2 = null;
            Set<Long> set3 = null;
            Set<Long> set4 = null;
            Set<Long> set5 = null;
            Set<Long> set6 = null;
            Set<Long> set7 = null;

            try {
                set1 = future1.get();
                set2 = future2.get();
                set3 = future3.get();
                set4 = future4.get();
                set5 = future5.get();
                set6 = future6.get();
                set7 = future7.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            resultTreeSet.addAll(set1);
            resultTreeSet.addAll(set2);
            resultTreeSet.addAll(set3);
            resultTreeSet.addAll(set4);
            resultTreeSet.addAll(set5);
            resultTreeSet.addAll(set6);
            resultTreeSet.addAll(set7);
        }

        long[] result = new long[resultTreeSet.size()];

        int i = 0;
        for (Long number : resultTreeSet) {
            result[i++] = number;
        }

        return result;
    }

    private static long getNextNumber(long prevNumber) {

        if (prevNumber++ % 10 != 9)
            return prevNumber;
        else {

            long lastFigure = prevNumber % 10;
            int countFigure = 0;

            while (lastFigure == 0) {
                prevNumber = prevNumber / 10;
                lastFigure = prevNumber % 10;
                countFigure++;
            }

            StringBuffer sbNumber = new StringBuffer(Long.toString(prevNumber));

            for (int i = 0; i < countFigure; i++)
                sbNumber.append(lastFigure);

            try {
                return Long.parseLong(sbNumber.toString());
            } catch (NumberFormatException e) {
                return Long.MAX_VALUE;
            }
        }
    }

    private static long getDividedByTen(long prevNumber) {
        long nextNumber = getNextNumber(prevNumber / 10) * 10;

        if (nextNumber > 0) {
            return nextNumber;
        } else {
            return Long.MAX_VALUE;
        }
    }

    private static long getHundredRankNumbers(long prevNumber) {
        long nextNumber = getNextNumber(prevNumber / 100) * 100;

        if (nextNumber > 0) {
            return nextNumber;
        } else {
            return Long.MAX_VALUE;
        }
    }

    private static long getThousandthNumbers(long prevNumber) {
        long nextNumber = getNextNumber(prevNumber / 1000) * 1000;

        if (nextNumber > 0) {
            return nextNumber;
        } else {
            return Long.MAX_VALUE;
        }
    }

    private static long isArmstrongNumber(long number) {
        List<Integer> listOfNumber = getDigitsList(number);

        long sum = sumOfDigits(listOfNumber);
        if (sum == Long.MAX_VALUE) {
            return -1;
        }

        List<Integer> listOfSumNumbers = getDigitsList(sum);

        if (listOfNumber.size() != listOfSumNumbers.size())
            return -1L;

        Collections.sort(listOfNumber);
        Collections.sort(listOfSumNumbers);

        if (listOfNumber.equals(listOfSumNumbers)) {
            return sum;
        } else {
            return -1L;
        }
    }

    private static long sumOfDigits(List<Integer> digitsList) {
        int degree = digitsList.size();

        long sum = 0;

        for (Integer currentDigit : digitsList) {
            sum += numbersInDegree[currentDigit][degree];
        }

        return sum;
    }

    // возвращает лист в котором цифры числа идут с конца к началу числа
    private static List<Integer> getDigitsList(long number) {
        List<Integer> resultList = new ArrayList<>();

        do {
            int currentDigit = (int) (number % 10);

            resultList.add(currentDigit);

            number /= 10;    // number = number / 10;

        } while (number > 0);

        return resultList;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long[] result = getNumbers(numberForCalculations);
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (long number : result) {
            System.out.print(number + " ");
        }

        long finish = System.currentTimeMillis();

        System.out.println("\nSize: " + result.length + " Armstrong`s numbers.");

        long seconds = (finish - start) / 1000;
        long miliseconds = (finish - start) % 1000;
        System.out.println("\nExecuting time: " + seconds + "." + miliseconds + " seconds.");

        long usedMemory = memory / 1_000_000;
        System.out.println("Used memory: " + usedMemory + " Mb.");


        //1111
        ////на Long.MAX_VALUE - 6_906_889 значений
//        int count = 0;
//        int previousPreLastDig = 1;
//
//        for (long i = 11; i < Long.MAX_VALUE; i = getNextNumber(i, getDigitsList(i))) {
//            List<Integer> list = getDigitsList(i);
//            Collections.reverse(list);
//
//            int size = list.size();
//            int preLastDig  = list.get(size - 2);
//
//            if (previousPreLastDig != preLastDig) {
//                System.out.print("\n" + i + " ");
//                previousPreLastDig = preLastDig;
//            } else {
//                System.out.print(i + " ");
//            }
//            count++;
//        }
//
//        System.out.println("\nCount: " + count);


        //2222
//        на Long.MAX_VALUE - 4_686_823 значений
//        int count = 0;
//        int previousPreLastDig = 1;
//
//        for (long i = 10; i < Long.MAX_VALUE; i = getDividedByTen(i, getDigitsList(i))) {
//            List<Integer> list = getDigitsList(i);
//            Collections.reverse(list);
//
//            int preLastDig;
//            int size = list.size();
//
//            if (size > 2) {
//                preLastDig = list.get(size - 3);
//            } else {
//                preLastDig = 10;
//            }
//
//            if (previousPreLastDig != preLastDig) {
//                System.out.print("\n" + i + " ");
//                previousPreLastDig = preLastDig;
//            } else {
//                System.out.print(i + " ");
//            }
//            count++;
//        }
//
//        System.out.println("\nCount: " + count);


        //3333
        //на Long.MAX_VALUE - 3_124_548 значений
//        int count = 0;
//        int previousPreLastDig = 1;
//
//        for (long i = 100; i < Long.MAX_VALUE; i = getHundredRankNumbers(i, getDigitsList(i))) {
//            List<Integer> list = getDigitsList(i);
//            Collections.reverse(list);
//
//            int preLastDig;
//            int size = list.size();
//
//            if (size > 3) {
//                preLastDig = list.get(size - 4);
//            } else {
//                preLastDig = 10;
//            }
//
//            if (previousPreLastDig != preLastDig) {
//                System.out.print("\n" + i + " ");
//                previousPreLastDig = preLastDig;
//            } else {
//                System.out.print(i + " ");
//            }
//            count++;
//        }
//
//        System.out.println("\nCount: " + count);

        //4444
        //на Long.MAX_VALUE - 2_042_974 значений
//        int count = 0;
//        int previousPreLastDig = 1;
//
//        for (long i = 1000; i < Long.MAX_VALUE; i = getThousandthNumbers(i, getDigitsList(i))) {
//            List<Integer> list = getDigitsList(i);
//            Collections.reverse(list);
//
//            int preLastDig;
//            int size = list.size();
//
//            if (size > 4) {
//                preLastDig = list.get(size - 5);
//            } else {
//                preLastDig = 10;
//            }
//
//            if (previousPreLastDig != preLastDig) {
//                System.out.print("\n" + i + " ");
//                previousPreLastDig = preLastDig;
//            } else {
//                System.out.print(i + " ");
//            }
//            count++;
//        }
//
//        System.out.println("\nCount: " + count);
    }
}

/*
        1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
        548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
        472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
        42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L,
        4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
        1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L
*/
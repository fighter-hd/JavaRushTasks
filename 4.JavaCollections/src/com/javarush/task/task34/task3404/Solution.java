package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.recurse("6.00", 0); //expected output 6 0
//        solution.recurse("7.6409", 0); //expected output 7.64 0
//        solution.recurse("7.6459", 0); //expected output 7.65 0
//        solution.recurse("-5", 0); //expected output -5 1
//        solution.recurse("+5", 0); //expected output 5 1
//        solution.recurse("+ -5", 0); //expected output -5 2
//        solution.recurse("2 +2", 0); //expected output 4 1
//        solution.recurse("(2 +5) * (4-3)", 0); //expected output 7 3
//        solution.recurse("15 * -3", 0); //expected output -45 2
//        solution.recurse("3 * 4^2", 0); //expected output 48 2
//        solution.recurse("(-3*2) ^ 2", 0); //expected output 36 3
//        solution.recurse("2 ^ (1*(1 + 2)) / 1", 0); //expected output 8 4
//        solution.recurse("0.305", 0); // expected output 0.3 0
//        solution.recurse("0.3051", 0); // expected output 0.31 0
//        solution.recurse("(0.3051)", 0); // expected output 0.31 0
//        solution.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0); // expected output 12 8
//        solution.recurse("-2+(-2+(-2)-2*(2+2))", 0); // expected output -14 8
//        solution.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0); // expected output 6 11
//        solution.recurse("10-2^(2-1+1)", 0); // expected output 6 4
//        solution.recurse("2^10+2^(5+5)", 0); // expected output 2048 4
//        solution.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0); // expected output 72.96 8
//        solution.recurse("0.000025+0.000012", 0); // expected output 0 1
//        solution.recurse("-(-2)", 0); // expected output 2 2
//        solution.recurse("--1+(-+-2)--3 * --4 - --5", 0); // expected output 10 14
//        solution.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0); // expected output -3 16
//        solution.recurse("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", 0); // expected output 8302231.36 14
//        solution.recurse("(-1 + (-2))", 0); // expected output -3 3
//
//        System.out.println();
//        solution.recurse("tan(45) + 3", 0); // expected output 4 2
//        solution.recurse("tan(45) + sin60", 0); // expected output 1.87 3
//        solution.recurse("-tan(-45) + sin-60", 0); // expected output 0.13 6
//        solution.recurse("-tan(-45) + -sin-60", 0); // expected output 1.87 7
//        solution.recurse("tan(45)", 0); // expected output 1 1
//        solution.recurse("tan(-45)", 0); // expected output -1 2
//        solution.recurse("tan(-15)", 0); //expected output -0.27 2
//        solution.recurse("-tan(15)", 0); //expected output -0.27 2
//        solution.recurse("cos(3 + 19*3)", 0); // expected output 0.5 3
//        solution.recurse("tan(2025 ^ 0.5)", 0); //expected output 1 2
//        solution.recurse("tan(2025 ^ (0.5 * 1) / (2-1) )", 0); //expected output 1 5
//        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//        solution.recurse("sin(2*(5+1.5*-4)+28)", 0); //expected output 0.44 6
//        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // expected output 0.5 6
//        solution.recurse("-sin(2*(-5+1.5*4)+28)", 0); // expected output -0.5 7
//        solution.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0); // expected output 1 7
//        solution.recurse("tan(44+sin(89-cos(180)^2))", 0); // expected output 1 6
//        solution.recurse("sin(100)-sin(100)", 0); // expected output 0 3
//
//        solution.recurse("tan(45)", 0);  System.out.println("1 1 - expected output");
//        solution.recurse("tan(-45)", 0);  System.out.println("-1 2 - expected output");
//        solution.recurse("0.305", 0);  System.out.println("0.3 0 - expected output");
//        solution.recurse("0.3051", 0);  System.out.println("0.31 - expected output");
//        solution.recurse("(0.3051)", 0);  System.out.println("0.31 - expected output");
//        solution.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);  System.out.println("12 8 - expected output");
//        solution.recurse("tan(44+sin(89-cos(180)^2))", 0);  System.out.println("1 6 - expected output");
//        solution.recurse("-2+(-2+(-2)-2*(2+2))", 0);  System.out.println("-14 8 - expected output");
//        solution.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);  System.out.println("1 7 - expected output");
//        solution.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);  System.out.println("6 11 - expected output");
//        solution.recurse("10-2^(2-1+1)", 0);  System.out.println("6 4 - expected output");
//        solution.recurse("2^10+2^(5+5)", 0);  System.out.println("2048 4 - expected output");
//        solution.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);  System.out.println("72.96 8 - expected output");
//        solution.recurse("0.000025+0.000012", 0);  System.out.println("0 1 - expected output");
//        solution.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);  System.out.println("-3 16 - expected output");
//        solution.recurse("cos(3 + 19*3)", 0);  System.out.println("0.5 3 - expected output");

        System.out.println();
        solution.recurse("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", 0);  System.out.println("8302231.36 14 - expected output");
        solution.recurse("(-1 + (-2))", 0);  System.out.println("-3 3 - expected output");
        solution.recurse("-sin(2*(-5+1.5*4)+28)", 0);  System.out.println("-0.5 7 - expected output");
        solution.recurse("sin(100)-sin(100)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("-(-22+22*2)", 0);  System.out.println("-22 4 - expected output");
        solution.recurse("-2^(-2)", 0);  System.out.println("-0.25 3 - expected output");
        solution.recurse("-(-2^(-2))+2+(-(-2^(-2)))", 0);  System.out.println("2.5 10 - expected output");
        solution.recurse("(-2)*(-2)", 0);  System.out.println("4 3 - expected output");
        solution.recurse("(-2)/(-2)", 0);  System.out.println("1 3 - expected output");
        solution.recurse("sin(-30)", 0);  System.out.println("-0.5 2 - expected output");
        solution.recurse("cos(-30)", 0);  System.out.println("-0.87 2 - expected output");
        solution.recurse("tan(-30)", 0);  System.out.println("-0.58 2 - expected output");
        solution.recurse("2+8*(9/4-1.5)^(1+1)", 0);  System.out.println("6.5 6 - expected output");
        solution.recurse("0.005", 0);  System.out.println("0.01 0 - expected output");
        solution.recurse("0.0049", 0);  System.out.println("0 0 - expected output");
        solution.recurse("0+0.304", 0);  System.out.println("0.3 1 - expected output");
        solution.recurse("sin(45) - cos(45)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("0/(-3)", 0);  System.out.println("0 2 - expected output");
    }

    public void recurse(final String expression, int countOperation) {
        String temp = new String(expression);
        boolean complete = false;
// operation's patterns
        Pattern mindetect=Pattern.compile("[^\\d)?]-|^-");//патерн для определения унарных минусов, сказочная дурь
        Pattern patPar = Pattern.compile("\\(([^()]*)\\)");//внутренние скобки
        Pattern patrem = Pattern.compile("\\((-?[\\d.]+)\\)");//поиск готовых цифр в скобках для раскрытия
        Pattern pow = Pattern.compile("(-?[\\d.]+)(\\^)(-?[\\d.]+)");//степень удаленно из начала (?:-|\+)
        Pattern sin = Pattern.compile("()(sin|cos|tan)(-?[\\d.]+)");//тригонометрия
        Pattern mul = Pattern.compile("(-?[\\d.]+)([*/])(-?[\\d.]+)");//умножение деление
        Pattern additive = Pattern.compile("(-?[\\d.]+)?([+M])(-?[\\d.]+)");//сложение вычитание
        // Pattern unar=Pattern.compile("()(M)([\\d.]+)");
        Pattern plusser = Pattern.compile("()(--)([\\d.]+)");//поиск двойных плюсов после различных операций
        Pattern round = Pattern.compile("(-?[\\d.]+)");//поиск готовых цифр для округления


        if(countOperation == 0){//добавляем унарные минусы в качестве операций возможно не потреб-ся. переименовываем все - в М
            Matcher matcher = mindetect.matcher(temp);
            temp = temp.replaceAll("-","M");//теперь все необработанные - это M
        }
        temp = temp.replaceAll(" +", "");//выпиливаем пробелы
        String calctemp = temp;
        int start = 0;
        int end = calctemp.length();
        Matcher mathPar = patPar.matcher(temp);//поехали! скобки
        if (mathPar.find()) {

            calctemp = mathPar.group(1);
            start = mathPar.start()+1;
            end = mathPar.end()-1;

        }


        String result = calc(calctemp, sin);//тригонометрия
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, pow);//степень
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, mul);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }
        result = calc(calctemp, plusser);
        if (!result.equals("")) {
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, additive);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        mathPar = patrem.matcher(temp);
        if (mathPar.find()) {
            temp = temp.substring(0,start-1)+mathPar.group(1)+temp.substring(end+1);;
            recurse(temp, countOperation);
            return;
        }
        NumberFormat nf = new DecimalFormat("#.##");
        Double d = Double.parseDouble(temp);
        System.out.println(String.format("%s %d", nf.format(d),countOperation).replace(",","."));

    }

    private String calc(String temp, Pattern pattern) {

        String result = "";
        String temporar = new String(temp);
        Matcher matcher = pattern.matcher(temporar);

        if (matcher.find()) {
            result = temporar.replaceFirst(pattern.pattern(), numerate(matcher));
        }
        return result;
    }

    private String numerate(Matcher matcher) {
        HashMap<String, DoubleBinaryOperator> hashMap = new HashMap();
        hashMap.put("*", (DoubleBinaryOperator) (double a, double b) -> a * b);
        hashMap.put("/", (DoubleBinaryOperator) (double a, double b) -> a / b);
        hashMap.put("M", (DoubleBinaryOperator) (double a, double b) -> a - b);
        hashMap.put("+", (DoubleBinaryOperator) (double a, double b) -> a + b);
        hashMap.put("++", (DoubleBinaryOperator) (double a, double b) -> b);
        hashMap.put("M-", (DoubleBinaryOperator) (double a, double b) -> b);
        hashMap.put("^", (DoubleBinaryOperator) (double a, double b) -> Math.pow(a, b));
        hashMap.put("cos", (DoubleBinaryOperator) (double a, double b) -> Math.cos(Math.toRadians(b)));
        hashMap.put("sin", (DoubleBinaryOperator) (double a, double b) -> Math.sin(Math.toRadians(b)));
        hashMap.put("tan", (DoubleBinaryOperator) (double a, double b) -> Math.tan(Math.toRadians(b)));
        String left = "0";
        String right = "0";

        try {
            left = matcher.group(1).equals("") ? "0" : matcher.group(1);
        } catch (Exception e) {
        }

        try {
            right = matcher.group(3).equals("") ? "0" : matcher.group(3);
        } catch (Exception e) {
        }

        Double dleft = Double.parseDouble(left);
        Double dright = Double.parseDouble(right);
        Double result = hashMap.get(matcher.group(2)).applyAsDouble(dleft, dright);
        NumberFormat nf = new DecimalFormat("#.##");

        return String.format("%s", nf.format(result)).replace(",",".");
    }


// Мой вариант, но не принял валидатор

//    public void recurse(final String expression, int countOperation) {
//        if (expression.contains(" ")) {
//            recurse(expression.replace(" ", ""), countOperation);
//            return;
//        }
//
//        if (countOperation == 0) {
//            countOperation = getCountOfOperations(expression);
//        }
//
//        if (isSomeExtraCharacters(expression)) {
//            recurse(removeExtraCharacters(expression), countOperation);
//            return;
//        }
//
//        if (isReadyToPrint(expression)) {
//            printResult(expression, countOperation);
//            return;
//        }
//
//        String smallestExpressionInBrackets = getSmallestExpressionInBrackets(expression);
//        String simpleExpression = getMaxPrioritySingleExpression(smallestExpressionInBrackets);
//        String simpleExpressionResult = getExpressionResult(simpleExpression);
//        String refreshedExpression = refreshExpression(expression, smallestExpressionInBrackets, simpleExpression, simpleExpressionResult);
//
//        recurse(refreshedExpression, countOperation);
//    }
//
//    private static int getCountOfOperations(String expression) {
//        int result = 0;
//
//        for (int i = 0; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//
//            if (c == '^' || c == '*' || c == '/' || c == '-' || c == '+' || c == 'i' || c == 'o' || c == 'a') {
//                result++;
//            }
//        }
//
//        return result;
//    }
//
//    private static boolean isSomeExtraCharacters(String expression) {
//        return expression.matches(".*[+-]{2,}.*") || expression.matches(".*[(][+-]*\\d+[.]?\\d*[)].*");
//    }
//
//    private static String removeExtraCharacters(String expression) {
//        String refreshedExpression = expression;
//
//        if (refreshedExpression.matches(".*[+-]{2,}.*")) {
//            refreshedExpression = removeExtraPlusesAndMinuses(refreshedExpression);
//        }
//
//        if (refreshedExpression.matches(".*[(][+-]*\\d+[.]?\\d*[)].*")) {
//            refreshedExpression = removeSingleNumberInBrackets(refreshedExpression);
//        }
//
//        if (isSomeExtraCharacters(refreshedExpression)) {
//            refreshedExpression = removeExtraCharacters(refreshedExpression);
//        }
//
//        return refreshedExpression;
//    }
//
//    private static String removeExtraPlusesAndMinuses(String expression) {
//        if (expression.contains("--")) {
//            expression = removeDoubleMinus(expression);
//        }
//
//        if (isSomeExtraPluses(expression)) {
//            expression = removeExtraPluses(expression);
//        }
//
//        if (expression.matches(".*[+-]{2,}.*")) {
//            expression = removeExtraPlusesAndMinuses(expression);
//        }
//
//        return expression;
//    }
//
//    private static String removeDoubleMinus(String expression) {
//        String refreshedExpression = expression;
//
//        Pattern pattern = Pattern.compile("--");
//        Matcher matcher = pattern.matcher(expression);
//
//        if (matcher.find()) {
//            int start = matcher.start();
//
//            if (start == 0) {
//                refreshedExpression = removeDoubleMinus(matcher.replaceFirst(""));
//
//            } else {
//                char previousSign = expression.charAt(start - 1);
//
//                if (Character.isDigit(previousSign) || previousSign == ')') {
//                    refreshedExpression = removeDoubleMinus(matcher.replaceFirst("+"));
//
//                } else {
//                    refreshedExpression = removeDoubleMinus(matcher.replaceFirst(""));
//                }
//            }
//        }
//
//        return refreshedExpression;
//    }
//
//    private static boolean isSomeExtraPluses(String expression) {
//        return expression.charAt(0) == '+' || expression.matches(".*[(^*/-]+[+].*") || expression.matches(".*[+][(^*/-]+.*");
//    }
//
//    private static String removeExtraPluses(String expression) {
//        String refreshedExpression = expression;
//
//        if (refreshedExpression.charAt(0) == '+') {
//            refreshedExpression = refreshedExpression.substring(1);
//        }
//
//        Pattern pattern = Pattern.compile("[(^*/-][+]");
//        Matcher matcher = pattern.matcher(refreshedExpression);
//
//        if (matcher.find()) {
//            int end = matcher.end();
//            refreshedExpression = refreshedExpression.substring(0, end - 1) + refreshedExpression.substring(end);
//        }
//
//        pattern = Pattern.compile("[+][)^*/-]");
//        matcher = pattern.matcher(refreshedExpression);
//
//        if (matcher.find()) {
//            int start = matcher.start();
//            refreshedExpression = refreshedExpression.substring(0, start) + refreshedExpression.substring(start + 1);
//        }
//
//        return refreshedExpression;
//    }
//
//    private static String removeSingleNumberInBrackets(String expression) {
//        String refreshedExpression = expression;
//
//        Pattern pattern = Pattern.compile("[(][+-]*\\d+[.]?\\d*[)]");
//        Matcher matcher = pattern.matcher(expression);
//
//        if (matcher.find()) {
//            int start = matcher.start();
//            int end = matcher.end();
//
//            String numberWithoutBrackets = expression.substring(start + 1, end - 1);
//
//            refreshedExpression = removeSingleNumberInBrackets(matcher.replaceFirst(numberWithoutBrackets));
//        }
//
//        return refreshedExpression;
//    }
//
//    private static boolean isReadyToPrint(String expression) {
//        return expression.matches("[+-]?[0-9]+[.]?[0-9]*");
//    }
//
//    private static void printResult(String expression, int countOperation) {
//        NumberFormat formatter = new DecimalFormat("#.##");
//        Double result = Double.parseDouble(expression);
//        String stringResult = String.format("%s %d", formatter.format(result),countOperation);
//        stringResult = stringResult.replace(",", ".");
//
//        if (stringResult.matches("[-][0]+[.]?[0]*[ ][0-9]+")) {
//            stringResult = stringResult.substring(1);
//        }
//
//        System.out.println(stringResult);
//    }
//
//    private static String getSmallestExpressionInBrackets(String expression) {
//        int openingBracketIndex = expression.indexOf('(');
//        int closingBracketIndex = 0;
//
//        if (openingBracketIndex > -1) {
//            for (int i = openingBracketIndex + 1; i < expression.length(); i++) {
//                if (expression.charAt(i) == ')') {
//                    closingBracketIndex = i;
//                    break;
//
//                } else if (expression.charAt(i) == '(') {
//                    openingBracketIndex = i;
//                }
//            }
//        }
//
//        if (openingBracketIndex > -1 && closingBracketIndex > openingBracketIndex) {
//            return expression.substring(openingBracketIndex, closingBracketIndex + 1);
//
//        } else { return expression; }
//    }
//
//    private static String getMaxPrioritySingleExpression(String expression) {
//        expression = removeBrackets(expression);
//
//        int maxPrioritySignIndex = getSignIndex(expression);
//        char signCharacter = expression.charAt(maxPrioritySignIndex);
//
//        int startIndex;
//
//        if (signCharacter == 's' || signCharacter == 'c' || signCharacter == 't') {
//            startIndex = maxPrioritySignIndex;
//
//        } else {
//            startIndex = getLeftIndex(expression, maxPrioritySignIndex);
//        }
//
//        int lastIndex = getRightIndex(expression, maxPrioritySignIndex);
//
//        if (startIndex < 0) {
//            startIndex = 0;
//        }
//
//        if (lastIndex >= expression.length()) {
//            lastIndex = expression.length() - 1;
//        }
//
//        if (   expression.substring(startIndex, maxPrioritySignIndex).contains("sin")
//            || expression.substring(startIndex, maxPrioritySignIndex).contains("cos")
//            || expression.substring(startIndex, maxPrioritySignIndex).contains("tan")) {
//
//            return expression.substring(startIndex, maxPrioritySignIndex);
//        }
//
//        if (   expression.substring(maxPrioritySignIndex + 1, lastIndex + 1).contains("sin")
//            || expression.substring(maxPrioritySignIndex + 1, lastIndex + 1).contains("cos")
//            || expression.substring(maxPrioritySignIndex + 1, lastIndex + 1).contains("tan")) {
//
//            return expression.substring(maxPrioritySignIndex + 1, lastIndex + 1);
//        }
//
//        return expression.substring(startIndex, lastIndex + 1);
//    }
//
//    private static String removeBrackets(String expression) {
//        if (expression.matches("[(].+[)]")) {
//            expression = expression.substring(1, expression.length() - 1);
//        }
//
//        return expression;
//    }
//
//    private static int getSignIndex(String expression) {
//        int index = 0;
//
//        if (expression.contains("^")) {
//            index = expression.indexOf('^');
//
//        } else if (expression.contains("*") || expression.contains("/")) {
//
//            for (int i = 0; i < expression.length(); i++) {
//                char currentChar = expression.charAt(i);
//
//                if (currentChar == '*' || currentChar == '/') {
//                    index = i;
//                    break;
//                }
//            }
//
//        } else if (expression.contains("+") || expression.contains("-")) {
//
//                for (int i = 0; i < expression.length(); i++) {
//                    char currentChar = expression.charAt(i);
//
//                    if (currentChar == '+' || currentChar == '-') {
//                        if (currentChar == '-') {
//                            index = getMinusIndex(expression);
//
//                            if (index > 2) {
//                                if (expression.charAt(index - 1) == 'n' || expression.charAt(index - 1) == 's') {
//                                    index -= 3;
//                                }
//                            }
//
//                        } else {
//                            index = i;
//                        }
//                        break;
//                    }
//                }
//
//        } else if (expression.contains("sin") || expression.contains("cos") || expression.contains("tan")) {
//            if (expression.contains("sin")) {
//                index = expression.indexOf("sin");
//
//            } else if (expression.contains("cos")) {
//                index = expression.indexOf("cos");
//
//            } else if (expression.contains("tan")) {
//                index = expression.indexOf("tan");
//            }
//        }
//
//        return index;
//    }
//
//    private static int getMinusIndex(String expression) {
//        int index = expression.indexOf('-');
//
//        if (index == 0) {
//            index = getSignIndex(expression.substring(1)) + 1;
//        }
//
//        return index;
//    }
//
//    private static int getLeftIndex(String expression, int searchStartIndex) {
//        int leftIndex = searchStartIndex - 1;
//
//        for (int i = searchStartIndex - 1; i >= 0; i--) {
//            String checkString = expression.substring(i, searchStartIndex);
//            if (checkString.matches("[sct]?[ioa]?[ns]?[-]?\\d*[.]?\\d+")) {
//                leftIndex = i;
//
//            } else {
//                break;
//            }
//        }
//
//        if (leftIndex > 0) {
//            char previousChar = expression.charAt(leftIndex - 1);
//
//            if (previousChar != '^' && previousChar != '*' && previousChar != '/' && previousChar != '+' && previousChar != '-') {
//                leftIndex++;
//            }
//        }
//
//        return leftIndex;
//    }
//
//    private static int getRightIndex(String expression, int searchStartIndex) {
//        int rightIndex = searchStartIndex;
//
//        for (int i = searchStartIndex; i < expression.length(); i++) {
//            String checkString = expression.substring(searchStartIndex + 1, i + 1);
//
//            if (checkString.matches("[sct]?[ioa]?[ns]?[-]?\\d*[.]?\\d*")) {
//                rightIndex = i;
//
//            } else {
//                break;
//            }
//        }
//
//        return rightIndex;
//    }
//
//    private static String getExpressionResult(String expression) {
//        int signIndex = getSignIndex(expression);
//
//        Double leftNumber = getLeftNumber(expression, signIndex);
//
//        Double rightNumber;
//        char c = expression.charAt(signIndex);
//        if (c == 's' || c == 'c' || c == 't') {
//            rightNumber = getRightNumber(expression, signIndex);
//
//        } else {
//            rightNumber = getRightNumber(expression, signIndex + 1);
//        }
//
//        Double result = computeValue(expression, leftNumber, rightNumber);
//
//        NumberFormat formatter = new DecimalFormat("#0.0000000000000000");
//        String stringResult = formatter.format(result);
//        stringResult = stringResult.replaceAll(",", ".");
//
//        return stringResult;
//    }
//
//    private static Double getLeftNumber(String expression, int startSearchIndex) {
//        if (startSearchIndex < 1) {
//            return Double.NaN;
//        }
//
//        int startIndex = getLeftIndex(expression, startSearchIndex);
//
//        String leftNumber = expression.substring(startIndex, startSearchIndex);
//
//        if (   leftNumber.charAt(0) == 's'
//            || leftNumber.charAt(0) == 'c'
//            || leftNumber.charAt(0) == 't') {
//
//            return computeAngle(leftNumber);
//        }
//
//        Double result = Double.parseDouble(leftNumber);
//        result = Double.valueOf(result);
//
//        return result;
//    }
//
//    private static Double getRightNumber(String expression, int startSearchIndex) {
//        int lastIndex = getRightIndex(expression, startSearchIndex);
//
//        String rightNumber = expression.substring(startSearchIndex, lastIndex + 1);
//
//        if (   rightNumber.charAt(0) == 's'
//            || rightNumber.charAt(0) == 'c'
//            || rightNumber.charAt(0) == 't') {
//
//            return computeAngle(rightNumber);
//        }
//
//        Double result = Double.parseDouble(rightNumber);
//
//        return result;
//    }
//
//    private static String refreshExpression(String expression, String smallestExpressionInBrackets, String simpleExpression, String newValue) {
//        String refreshedSmallestExpressionInBrackets;
//
//        if (newValue.matches(".+[.][0]*")) {
//            int doteIndex = newValue.lastIndexOf('.');
//
//            newValue = newValue.substring(0, doteIndex);
//        }
//
//        if (newValue.matches("[0]+[.]?[0]*")) {
//            refreshedSmallestExpressionInBrackets = smallestExpressionInBrackets.replace(simpleExpression, "");
//
//        } else if (checkPreviousCharacter(smallestExpressionInBrackets, simpleExpression, newValue)) {
//            refreshedSmallestExpressionInBrackets = smallestExpressionInBrackets.replace(simpleExpression, "+" + newValue);
//
//        } else {
//            refreshedSmallestExpressionInBrackets = smallestExpressionInBrackets.replace(simpleExpression, newValue);
//        }
//
//        if (refreshedSmallestExpressionInBrackets.matches("[(][+-]?[1-9]+[0-9]*[.]?[0-9]*[)]")
//                || refreshedSmallestExpressionInBrackets.matches("[(][+-]?[0][.][0-9]+[)]")) {
//
//            int length = refreshedSmallestExpressionInBrackets.length();
//            refreshedSmallestExpressionInBrackets = refreshedSmallestExpressionInBrackets.substring(1, length - 1);
//        }
//
//        String result = expression.replace(smallestExpressionInBrackets, refreshedSmallestExpressionInBrackets);
//
//        if (result.isEmpty()) {
//            result = "0";
//        }
//
//        return result;
//    }
//
//    private static boolean checkPreviousCharacter(String smallestExpressionInBrackets, String simpleExpression, String newValue) {
//        if (Character.isDigit(newValue.charAt(0))) {
//            int startIndex = smallestExpressionInBrackets.indexOf(simpleExpression);
//
//            if (startIndex > 0) {
//                char previousCharacter = smallestExpressionInBrackets.charAt(startIndex - 1);
//
//                if (Character.isDigit(previousCharacter) || previousCharacter == ')') {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private static Double computeValue(String expression, Double leftNumber, Double rightNumber) {
//        Double result = Double.NaN;
//
//        if (expression.contains("^")) {
//            result = power(leftNumber, rightNumber);
//
//        } else if (expression.contains("*")) {
//            result = leftNumber * rightNumber;
//
//        } else if (expression.contains("/")) {
//            result = leftNumber / rightNumber;
//
//        } else if (expression.contains("+")) {
//            result = leftNumber + rightNumber;
//
//        } else if (expression.contains("-")) {
//            if (leftNumber.isNaN()) {
//                if (rightNumber >= 0) {
//                    result = -rightNumber;
//
//                } else {
//                    result = rightNumber;
//                }
//
//            } else {
//                if (rightNumber >= 0) {
//                    result = leftNumber - rightNumber;
//
//                } else {
//                    result = leftNumber + rightNumber;
//                }
//            }
//
//        } else if (expression.startsWith("sin") || expression.startsWith("cos") || expression.startsWith("tan")) {
//            result = computeAngle(expression);
//        }
//
//        return result;
//    }
//
//    private static Double power(Double a, Double b){
//        Double result = 1.0;
//
//        if (b > 0) {
//            for (int i = 0; i < b; i++){
//                result *= a;
//            }
//
//        } else {
//            for (int i = 0; i > b; i--){
//                result *= a;
//            }
//
//            if (a < 0) {
//                result *= -1;
//            }
//
//            result = 1 / result;
//        }
//
//        return result;
//    }
//
//    private static Double computeAngle(String expression) {
//        double resultValue = 0;
//        double startValue;
//        int numberStartIndex = 3;
//
//        startValue = getRightNumber(expression, numberStartIndex);
//
//        double radiansValue = Math.toRadians(startValue);
//
//            char firstLetter = expression.charAt(0);
//
//            if (firstLetter == 's' || firstLetter == 'c' || firstLetter == 't') {
//                String type = expression.substring(0, 3);
//
//                switch (type) {
//                    case "sin":
//                        resultValue = Math.sin(radiansValue);
//                        break;
//
//                    case "cos":
//                        resultValue = Math.cos(radiansValue);
//                        break;
//
//                    case "tan":
//                        resultValue = Math.tan(radiansValue);
//                        break;
//                }
//            }
//
//        return resultValue;
//    }

    public Solution() {
        //don't delete
    }
}

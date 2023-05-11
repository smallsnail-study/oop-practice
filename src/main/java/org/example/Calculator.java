package org.example;

public class Calculator {
//    public static int calcurate(int operate1, String operator, int operate2) { // 2개의 피연산자와 1개의 연산자필요
//        if ("+".equals(operator)) {
//            return operate1 + operate2;
//        } else if ("-".equals(operator)) {
//            return operate1 - operate2;
//        } else if ("*".equals(operator)) {
//            return operate1 * operate2;
//        } else if ("/".equals(operator)) {
//            return operate1 / operate2;
//        }
//        return 0;
//    }

    // 위 코드를 Refactoring
    public static int calculate(int operate1, String operator, int operate2) { // 2개의 피연산자와 1개의 연산자필요
       return ArithmeticOperator.calculate(operate1,operator,operate2);
    }
}

package org.example.calculator.calculate;

public class MultiplicationOperator implements NewArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "*".equals(operator);
    }

//    @Override
//    public int calculate(int operand1, int operand2) {
//        return operand1 * operand2;
//    }

    // 3차 Refactoring 양수로만 계산할 수 있다. 조건반영
    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() * operand2.toInt();
    }
}

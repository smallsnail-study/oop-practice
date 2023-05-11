package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 사칙연산 계산기 구현
 * • 요구사항
 * • 간단한 사칙연산을 할 수 있다.
 * • 양수로만 계산할 수 있다.
 * • 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

    // 1 + 2 ---> 2개의 피연산자와 1개의 연산자를 Calcurator에게 전달해서 작업위임
    // Calcurator에 위 규약을 public interface로 생성
    // 3  <--- Calcurator는 결과값을 전달
//    @DisplayName("덧셈 연산을 수행한다.")
//    @Test
//    void additionTest() {
//
//        int result = Calcurator.calculate(1, "+", 2);
//
//        assertThat(result).isEqualTo(3);
//    }
//    @DisplayName("뺄셈 연산을 수행한다.")
//    @Test
//    void subtractionTest() {
//
//        int result = Calcurator.calculate(1, "-", 2);
//
//        assertThat(result).isEqualTo(-1);
//    }

    // 각각의 연산 수행에서 사칙연산을 한 번에 수행하는 메소드로 Refactoring
    @DisplayName("사칙 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {

        int calculateResult = Calculator.calculate(operand1, operator, operand2);

        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
            arguments(1,"+",2,3),
            arguments(1,"-",2,-1),
            arguments(4,"*",2,8),
            arguments(4,"/",2,2)
        );
    }
}

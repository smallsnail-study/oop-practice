package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 사칙연산 계산기 구현
 * • 요구사항
 * • 간단한 사칙연산을 할 수 있다.
 * • 양수로만 계산할 수 있다.
 * • 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalcuratorTest {

    // 1 + 2 ---> 2개의 피연산자와 1개의 연산자를 Calcurator에게 전달해서 작업위임
    // Calcurator에 위 규약을 public interface로 생성
    // 3  <--- Calcurator는 결과값을 전달
    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() {

        int result = Calcurator.calcurate(1, "+", 2);

        assertThat(result).isEqualTo(3);
    }
    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void subtractionTest() {

        int result = Calcurator.calcurate(1, "-", 2);

        assertThat(result).isEqualTo(-1);
    }
}

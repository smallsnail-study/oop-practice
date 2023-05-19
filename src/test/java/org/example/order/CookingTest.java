package org.example.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        //요리사 객체
        Chef chef = new Chef();
        MenuItem menuItem = new MenuItem("돈까스", 5000);

        // 요리사가 요리를 만들어달라고 요청하고 -> 어떤걸 만들지는 menuItem을 전달
        Cook cook = chef.makeCook(menuItem);

        // 객체들끼리 비교할때는 equals(),hashCode()가 필요
        assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
    }
}

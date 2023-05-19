package org.example.credit;

import java.util.List;

//일급 컬렉션 사용(List 형태로 된 Course 정보만 instance 변수로 가지는 클래스)
// List<Course>로 처리할 수 있는 정보들이 해당 클래스 안으로 이동(변화에 유연)
public class Courses {
    // List<Course> 이외의 변수를 가지면 안된다.
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        // 이수한 과목들의 학점수 x 성적 정보를 합산
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        // 이수한 과목들의 학점수들을 합산
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}

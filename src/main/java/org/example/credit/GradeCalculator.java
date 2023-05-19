package org.example.credit;

import java.util.List;
/**
 * 요구사항
 * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계 / 수강신청 총학점 수
 * 일급 컬렉션 사용
 */
public class GradeCalculator {

    // 일급 컬렉션 사용으로 Refactoring
    private final Courses courses;

    // 일급 컬렉션을 List로 받더라도 일급 컬렉션으로 전달하도록 변경
    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    // 일급 컬렉션으로 직접 받아 오는 것도 가능
    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }

// <핵심포인트> 협력을 설계
// 이수한 과목을 전달하여 평균학점 계산 요청 --> 학점계산기 -->(학점수 x 교과목평점)의 합계 ---> 과목(코스) 일급 컬렉션
//                                                  --> 수강신청 총 학점 수 ----> 과목(코스) 일급 컬렉션
    public double calculateGrade() {

        //(과목당 학점수 × 교과목 평점)의 합계 일급 컬렉션에 위임
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        // 수강신청 총 학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        //평균학점 계산 방법 = (학점수×교과목 평점)의 합계 / 수강신청 총학점 수
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}

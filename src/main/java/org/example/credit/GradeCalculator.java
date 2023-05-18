package org.example.credit;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계 / 수강신청 총학점 수
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {
//        return 4.5; test코드가 정상작동하는 지 확인 후 메소드 작성
        /**
         * 아래 getter 방법의 단점 : 아래 for문 부분이 여러군데에서 사용될 경우 로직이 바뀐다면 모두 수정해줘야 한다. -> 응집도가 약함
         */
        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
//            //(과목당 학점수 × 학점에 해당하는 점수) 계산
//            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
//        }

        /**
         * 위의 for문을 refactoring
         * 대신 Course 클래스에서 for문을 사용하는 방식으로, 객체에 작업을 위임한다면 로직이 변경되더라도,
         * Course 클래스의 multiplyCreditAndCourseGrade 부분만 수정하면 된다. -> 응집도가 높다. (변화에 유연)
         */
        for (Course course : courses) {
            //(과목당 학점수 × 학점에 해당하는 점수) 계산
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        // 수강신청 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        //평균학점 계산 방법 = (학점수×교과목 평점)의 합계 / 수강신청 총학점 수
        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}

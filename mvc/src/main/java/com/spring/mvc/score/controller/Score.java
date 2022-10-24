package com.spring.mvc.score.controller;

import com.spring.mvc.score.domain.Grade;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import static com.spring.mvc.score.domain.Grade.*;
// import static : 앞에 Grade. 생략 가능

@Getter
@Setter
@ToString
//@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화 생성자
@Log4j2
public class Score {
    // 클라이언트가 전달할 데이터
    private String name; // 학생 이름
    private int kor, eng, math; // 국, 영, 수 점수

    // 서버에서 생성하는 데이터
    private int stuNum; // 학번
    private int total; // 총점
    private double average; // 평균
    private Grade grade = A; // 학점 - enum(열거형) : 정해진 데이터 값만 들어와야 할 때 사용하면 유용함

    // static으로 안적어주면 밑의 Score 생성자까지 공유가 안됨
    private static int seq;

    public Score() {
        this.stuNum = ++seq;
    }

    // 총점 평균 계산
    public void calcTotalAndAvg() {
        this.total = kor + eng + math;
        this.average = total / 3.0;
    }
    // 학점 계산
    public void calcGrade() {
        if (this.average >= 90) {
            this.grade = A;
        } else if (this.average >= 80) {
            this.grade = B;
        } else if (this.average >= 70) {
            this.grade = C;
        } else if (this.average >= 60) {
            this.grade = D;
        } else {
            this.grade = F;
        }
    }
}

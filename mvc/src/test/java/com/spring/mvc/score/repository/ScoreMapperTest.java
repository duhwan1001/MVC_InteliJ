package com.spring.mvc.score.repository;

import com.spring.mvc.score.controller.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("상식정보 1개를 정확하게 데이터베이스에 저장해야 한다")
    void saveTest() {
        //given : 테스트시 주어질 데이터
        Score s = new Score();
        s.setName("김드한");
        s.setKor(100);
        s.setEng(86);
        s.setMath(99);
        s.calcTotalAndAvg();
        s.calcGrade();

        //when : 테스트 상황
        boolean result = mapper.save(s);

        //then : 테스트 결과
        assertTrue(result);
    }

    @Test
    @DisplayName("성적정보를 전체 조회해야 한다.")
    void findAllTest() {

        List<Score> scoreList = mapper.findAll("");

        assertEquals(3, scoreList.size());
        assertEquals("김두환", scoreList.get(0).getName());
        assertEquals(100, scoreList.get(2).getKor());

        for(Score score : scoreList) {
            System.out.println(score);
        }
    }

    @Test
    @DisplayName("성적 정보 1개를 정확하게 조회해야 한다.")
    void findOneTest() {

        int stuNum = 2;

        Score score = mapper.findOne(stuNum);

        assertEquals("김드한", score.getName());
        assertEquals(285, score.getTotal());
    }

    @Test
    @DisplayName("성적 정보 1개를 삭제해야 한다.")
    @Transactional
    @Rollback
    void deleteTest() {

        int stuNum = 3;

        boolean result = mapper.remove(stuNum);
        Score score = mapper.findOne(stuNum);

        assertNull(score);
    }
}
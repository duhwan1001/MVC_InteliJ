package com.spring.mvc.score.repository;

import com.spring.mvc.score.controller.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 점수 저장소
// 역할 : 성적정보를 저장하고 조회하고 삭제하는 일을 수행
@Mapper
public interface ScoreMapper {

    boolean save(Score score);

    List<Score> findAll(String sort);

    Score findOne(int stuNum);

    boolean remove(int stuNum);
}

package com.spring.mvc.score.service;

import com.spring.mvc.score.controller.Score;
import com.spring.mvc.score.repository.ScoreMapper;
import com.spring.mvc.score.repository.ScoreRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// 역할 : 컨트롤러와 저장소 사이의 중간 처리 담당
@RequiredArgsConstructor
@Service
public class ScoreService {

    private final ScoreMapper repository;
//    private final ScoreRepository repository;

    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public List<Score> findAllService(String sort) {
        // jsp에게 점수 정보 리스트를 전달해야 함.
        List<Score> scoreList = repository.findAll(sort);

        // 이름 마킹 처리
        for (Score s : scoreList) {
            String original = s.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            for (int i = 0; i < original.length() - 1; i++) {
                markName.append("*");
            }
            s.setName(markName.toString());
        }
        return scoreList;
    }


}

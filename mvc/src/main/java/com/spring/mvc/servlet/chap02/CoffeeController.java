package com.spring.mvc.servlet.chap02;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class CoffeeController {

    // 커피 주문 폼 화면 열기 요청
    @RequestMapping(name = "/coffee/form")
    public String form() {
        log.info("/coffee/form 호출됨");
        return "coffee/coffee-form";
    }

    // 커피 주문 처리 요청
    @PostMapping("/coffee/result")
    public String result(String menu, int price, HttpServletRequest req) {

        switch (menu) {
            case "americano":
                menu = "아메리카노";
                break;
            case "cafeLatte":
                menu = "카페라떼";
                break;
        }

        log.info("/coffee/result POST 요청 발생 - menu: {}, price: {}", menu, price);
        req.setAttribute("m", menu);
        req.setAttribute("p", price);
        return "coffee/coffee-result";
    }
}

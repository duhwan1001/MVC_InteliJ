package com.spring.mvc.servlet.chap02;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.http2.HPackHuffman;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller // 빈 등록 : 스프링컨테이너에 객체 생성을 위임
            // 스프링의 프론트컨트롤러가 이 클래스를 HandlerMapping으로 찾음
@Log4j2
public class BasicController {

    @Getter @Setter @ToString
    // Getter, Setter 어노테이션 이용해서 굳이 메서드 선언없이 사용 가능
    static class Order {
        private int num;
        private String goods;
        private int price;
    }

    @RequestMapping("/spring/about")
    public String about() {
//        System.out.println("/about 요청 발생");
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        // sout로 log 찍지말고 log4j 이용해서 log 찍을 것 *sout는 메모리도 많이 잡아먹어서 좋지않음
        return "test";
    }

    @RequestMapping("/spring/hello")
    public String hello() {
        System.out.println("/hello 요청 발생");
        return "redirect:/spring/about";
    }

    @RequestMapping("/spring/join")
    public String join(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println("id = " + id);
        return "";
    }

    @RequestMapping("/spring/join2")
    //RequestParam을 이용하면 파라미터를 hobby가 아닌 h로 받을수 있다.
    public String join(@RequestParam("h")String hobby) {
//        String id = request.getParameter("id");
        System.out.println("id = " + hobby);
        return "";
    }

    // 커맨드 객체로 파라미터 읽기
    // /spring/order?num=5566&goods=book&price=5000
    @RequestMapping("/spring/order")
    public String order(Order order) {
        System.out.println(order.goods);
        System.out.println(order.num);
        System.out.println(order.price);
        return "";
    }
}

package com.song.service.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
 *
 * @GetMapping
 * HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어준다.
 * /hello로 요청이 오면 hello 함수에 매핑되게 된다.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
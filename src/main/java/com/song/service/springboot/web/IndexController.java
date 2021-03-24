package com.song.service.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Mustache 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
 * (경로 : src/main/resources/templates, 파일 확장자 : .mustache)
 *
 * 즉, 여기서는 index를 반환하므로, src/main/resources/templates/index.mustache 로 전환되어 View Resolver가 처리하게 된다.
 *
 * ViewResolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}

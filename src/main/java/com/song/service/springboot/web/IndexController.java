package com.song.service.springboot.web;

import com.song.service.springboot.config.auth.LoginUser;
import com.song.service.springboot.config.auth.dto.SessionUser;
import com.song.service.springboot.service.posts.PostsService;
import com.song.service.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * Mustache 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
 * (경로 : src/main/resources/templates, 파일 확장자 : .mustache)
 *
 * 즉, 여기서는 index를 반환하므로, src/main/resources/templates/index.mustache 로 전환되어 View Resolver가 처리하게 된다.
 *
 * ViewResolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격
 *
 * Model
 * 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}

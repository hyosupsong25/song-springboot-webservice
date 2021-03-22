package com.song.service.springboot.web.dto;

import com.song.service.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity 클래스와 거의 유사한 형태이지만 Dto 클래스를 추가로 생성하였다.
 * 절대로 Entity 클래스를 Request / Response 클래스로 사용해서는 안된다.
 * "Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스"
 *
 * View Layer와 DB Layer의 역할 분리를 철저하게 하는 것이 좋다.
 * (실제로 Controller에서 결괏값으로 여러 테이블을 조인해서 줘야 하는 경우가 빈번하다)
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder().title(title).content(content).author(author).build();
    }
}

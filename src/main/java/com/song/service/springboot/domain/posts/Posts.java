package com.song.service.springboot.domain.posts;

import com.song.service.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Posts 클래스
 * 실제 DB의 테이블과 매칭될 클래스 (보통 Entity 클래스라고 부른다)
 * JPA를 사용하는 경우 실제 쿼리를 날리기 보다는 Entity 클래스의 수정을 통해 작업한다.
 *
 * @Entity
 * 테이블과 링크될 클래스임을 나타내는 어노테이션
 * default로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름 매칭
 *
 * @Id
 * 해당 테이블의 PK 필드임을 나타내는 어노테이션
 *
 * @GeneratedValue
 * PK의 생성 규칙을 나타낸다.
 * GenerationType.IDENTITY -> auto_increment(springboot 버전마다 다르다)
 *
 * @Column
 * 테이블의 칼럼을 나타내며 굳이 선어하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다.
 * 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
 * 문자열의 경우 VARCHAR(255)가 기본값 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶을때 사용
 *
 * @NoArgsConstructor
 * 기본 생성자 자동 추가
 *
 * @Getter
 * 클래스 내 모든 필드의 Getter 메소드를 자동생성
 *
 * @Builder
 * 해당 클래스의 빌더 패턴 클래스를 생성
 * 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
 */

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

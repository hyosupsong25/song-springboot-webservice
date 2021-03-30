package com.song.service.springboot.service.posts;

import com.song.service.springboot.domain.posts.Posts;
import com.song.service.springboot.domain.posts.PostsRepository;
import com.song.service.springboot.web.dto.PostsListResponseDto;
import com.song.service.springboot.web.dto.PostsResponseDto;
import com.song.service.springboot.web.dto.PostsSaveRequestDto;
import com.song.service.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Spring에서 Bean을 주입받는 방식들이 3가지 있다.
 * @Autowired / setter / 생성자
 * 이 중에서 생성자로 주입받는 방식이 가장 권장되고 @Autowired는 권장되지 않는다.
 * 즉, 생성자로 Bean 객체를 받도록 해서 @Autowired와 동일한 효과를 가져간다. -> RequiredArgsConstructor가 final이 선언된 모든 필드를 인자값으로 하는 생성자를 만들어준다.
 * 
 * 롬복 어노테이션을 사용하는 이유
 * 해당 클래스의 의존성 관계가 변경될 때마다 생성자를 계속해서 수정하는 번거로움을 해결하기 위함
 */

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}

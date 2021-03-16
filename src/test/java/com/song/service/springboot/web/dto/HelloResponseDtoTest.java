package com.song.service.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * assertThat
 * assertj라는 테스트 검증 라이브러리의 검증 메소드
 * 검증하고 싶은 대상을 메소드 인자로 받음
 * 메ㅐ소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용 가능
 *
 * isEqualTo
 * assertj의 동등 비교 메소드
 * assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
 *
 * Junit의 assertThat / assertj의 assertThat 장점
 * CoreMatchers와 달리 추가적인 라이브러리가 필요하지 않다
 * - Junit은 is()와 같이 CoreMatchers 라이브러리가 필요하다
 * 자동완성이 좀 더 확실하게 지원된다
 *
 */
public class HelloResponseDtoTest {

    @Test
    public void testLomBokFunction() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
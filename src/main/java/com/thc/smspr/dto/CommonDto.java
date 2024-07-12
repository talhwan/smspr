package com.thc.smspr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

import java.util.List;

//2024-07-12 추가 클래스
public class CommonDto {

	@Builder
	@Schema
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class PostDetailResDto {
		String id;
		String title;
		String content;
		String title2;
	}

}
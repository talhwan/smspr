package com.thc.smspr.mapper;

import com.thc.smspr.dto.CommonDto;

import java.util.List;
import java.util.Map;

//2024-07-11 추가(클래스 처음 추가함)
public interface TbpostMapper {
	/**/
	CommonDto.PostDetailResDto detail(String id);
	List<CommonDto.PostDetailResDto> list(Map<String, Object> param);

}
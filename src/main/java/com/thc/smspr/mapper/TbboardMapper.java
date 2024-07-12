package com.thc.smspr.mapper;

import com.thc.smspr.dto.CommonDto;

import java.util.List;
import java.util.Map;

//2024-07-12 추가(클래스 처음 추가함)
public interface TbboardMapper {
	/**/
	CommonDto.TbboardDetailResDto detail(String id);
	List<Map<String, Object>> list(Map<String, Object> param);

}
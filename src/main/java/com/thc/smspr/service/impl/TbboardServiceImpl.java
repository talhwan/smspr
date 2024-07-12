package com.thc.smspr.service.impl;

import com.thc.smspr.domain.Tbboard;
import com.thc.smspr.dto.CommonDto;
import com.thc.smspr.mapper.TbboardMapper;
import com.thc.smspr.repository.TbboardRepository;
import com.thc.smspr.service.TbboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2024-07-12 추가(클래스 처음 추가함)
@Service
public class TbboardServiceImpl implements TbboardService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TbboardRepository tbboardRepository;
    private final TbboardMapper tbboardMapper;

    public TbboardServiceImpl(
            TbboardRepository tbboardRepository,
            TbboardMapper tbboardMapper
    ) {
        this.tbboardRepository = tbboardRepository;
        this.tbboardMapper = tbboardMapper;
    }

    /**/

    public Map<String, Object> create(Map<String, Object> param){
        Map<String, Object> returnVal = new HashMap<>();
        Tbboard tbboard = Tbboard.of(param.get("title") + "", param.get("content") + "", param.get("writer") + "");
        tbboardRepository.save(tbboard);
        returnVal.put("resultCode", 200);
        return returnVal;
    }

    @Override
    public Map<String, Object> update(Map<String, Object> param) {

        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 0;

        String id = param.get("id") + "";
        Tbboard tbboard = tbboardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        if(param.get("title") != null && !"".equals(param.get("title"))){
            tbboard.setTitle(param.get("title") + "");
            resultCode = 200;
        }
        if(param.get("content") != null && !"".equals(param.get("content"))){
            tbboard.setContent(param.get("content") + "");
            resultCode = 200;
        }
        if(param.get("writer") != null && !"".equals(param.get("writer"))){
            tbboard.setWriter(param.get("writer") + "");
            resultCode = 200;
        }
        tbboardRepository.save(tbboard);

        returnVal.put("resultCode", resultCode);
        return returnVal;
    }

    @Override
    public Map<String, Object> delete(String id) {
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        Tbboard tbboard = tbboardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        tbboardRepository.delete(tbboard);

        returnVal.put("resultCode", resultCode);
        return returnVal;
    }

    @Override
    public Map<String, Object> detail(String id) {
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        Tbboard tbboard = tbboardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        CommonDto.TbboardDetailResDto mapTbboard = tbboardMapper.detail(id);

        returnVal.put("resultCode", resultCode);
        //returnVal.put("resultData", tbboard);
        returnVal.put("resultData", mapTbboard);
        return returnVal;
    }

    public Map<String, Object> list() {
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        List<Tbboard> list_tbboard = tbboardRepository.findAll();
        List<Map<String, Object>> list_tbboard1 = tbboardMapper.list(returnVal);

        returnVal.put("resultCode", resultCode);
        //returnVal.put("resultData", list_tbboard);
        returnVal.put("resultData", list_tbboard1);
        return returnVal;
    }
}

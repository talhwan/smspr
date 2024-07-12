package com.thc.smspr.service.impl;

import com.thc.smspr.dto.CommonDto;
import com.thc.smspr.mapper.TbpostMapper;
import com.thc.smspr.repository.TbpostRepository;
import com.thc.smspr.service.TbpostService;
import com.thc.smspr.domain.Tbpost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2024-07-08 추가(클래스 처음 추가함)
@Service
public class TbpostServiceImpl implements TbpostService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TbpostRepository tbpostRepository;
    private final TbpostMapper tbpostMapper;
    public TbpostServiceImpl(
            TbpostRepository tbpostRepository,
            TbpostMapper tbpostMapper
    ) {
        this.tbpostRepository = tbpostRepository;
        this.tbpostMapper = tbpostMapper;
    }

    /**/

    public Map<String, Object> create(Map<String, Object> param){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;
        String resultData = "";

        Tbpost tbpost = Tbpost.of(param.get("title") + "", param.get("content") + "");
        try{
            tbpostRepository.save(tbpost);
        } catch (Exception e){
            resultCode = 0;
        }
        returnData.put("resultCode", resultCode);
        return returnData;
    }
    public Map<String, Object> update(Map<String, Object> param){

        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 0;
        String resultData = "";
        String id = param.get("id") + "";
        Tbpost tbpost = tbpostRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        String title = param.get("title") + "";
        String content = param.get("content") + "";

        System.out.println("param : " + param);

        if("".equals(title) || "null".equals(title)){
        } else {
            tbpost.setTitle(title);
            resultCode = 200;
        }
        if("".equals(content) || "null".equals(content)){
        } else {
            tbpost.setContent(content);
            resultCode = 200;
        }
        try{
            tbpostRepository.save(tbpost);
        } catch (Exception e){
            resultCode = 0;
        }

        returnData.put("resultCode", resultCode);
        return returnData;
    }
    public Map<String, Object> delete(String id){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;

        Tbpost tbpost = tbpostRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        try{
            tbpostRepository.delete(tbpost);
        } catch (Exception e){
            resultCode = 0;
        }

        returnData.put("resultCode", resultCode);
        return returnData;
    }
    public Map<String, Object> detail(String id){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;
        /*
        Tbpost tbpost = tbpostRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        Map<String, Object> mapTbpost = new HashMap<String, Object>();
        mapTbpost.put("id", tbpost.getId());
        mapTbpost.put("title", tbpost.getTitle());
        mapTbpost.put("content", tbpost.getContent());
        */
        CommonDto.PostDetailResDto dtoTest = tbpostMapper.detail(id);

        returnData.put("resultCode", resultCode);
        returnData.put("resultData", dtoTest);
        return returnData;
    }
    public Map<String, Object> list(String title){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;

        List<Map<String, Object>> listMapTbpost = new ArrayList<>();
        List<Tbpost> listTbpost = tbpostRepository.findAll();

        List<Tbpost> listTbpost2 = tbpostRepository.findByTitle(title);
        System.out.println(listTbpost2.size());
        for(Tbpost tbpost : listTbpost2){
            System.out.println("haha : " + tbpost.getTitle());
        }

        for(Tbpost tbpost : listTbpost){
            Map<String, Object> mapTbpost = new HashMap<String, Object>();
            mapTbpost.put("id", tbpost.getId());
            mapTbpost.put("title", tbpost.getTitle());
            mapTbpost.put("content", tbpost.getContent());

            //Map<String, Object> each = detail(tbpost.getId());
            listMapTbpost.add(mapTbpost);
        }
        Map<String, Object> searchParam = new HashMap<String, Object>();
        searchParam.put("title", title);
        List<CommonDto.PostDetailResDto> listTest = tbpostMapper.list(searchParam);

        returnData.put("resultCode", resultCode);
        returnData.put("list", listTest);
        return returnData;

    }
}

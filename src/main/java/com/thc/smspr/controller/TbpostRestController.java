package com.thc.smspr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/tbpost")
@RestController
public class TbpostRestController {

    List<Map<String, Object>> tbpostList = new ArrayList<>();

    //2024-07-10
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 0;
        String title = params.get("title") + "";
        String content = params.get("content") + "";
        if("".equals(title) || "null".equals(title)){
            resultCode = -100;
        } else if("".equals(content) || "null".equals(content)){
            resultCode = -200;
        } else {
            resultCode = 200;
            Map<String, Object> tbpostMap = new HashMap<String, Object>();
            tbpostMap.put("order", tbpostList.size() + 1);
            tbpostMap.put("title", title);
            tbpostMap.put("content", content);
            tbpostList.add(tbpostMap);
        }

        returnData.put("resultCode", resultCode);
        returnData.put("data", tbpostList.size());
        return returnData;
    }
@GetMapping("/list")
    public Map<String, Object> list(){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;
        returnData.put("resultCode", resultCode);
        returnData.put("data", tbpostList);
        return returnData;
    }


}

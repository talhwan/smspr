package com.thc.smspr.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/tbboard")
@RestController
public class TbboardRestController {

    List<Map<String, Object>> tbboardList = new ArrayList<>();

    @GetMapping("/create")
    public Map<String, Object> create(
            @RequestParam String title
            , @RequestParam String content
            , @RequestParam String writer
    ){
        Map<String, Object> returnVal = new HashMap<>();
        Map<String, Object> tbboard = new HashMap<>();
        tbboard.put("order", tbboardList.size() + 1);
        tbboard.put("title", title);
        tbboard.put("content", content);
        tbboard.put("writer", writer);

        tbboardList.add(tbboard);

        returnVal.put("resultCode", 200);
        returnVal.put("order", tbboardList.size());
        return returnVal;
    }
    @GetMapping("/list")
    public Map<String, Object> list(){
        Map<String, Object> returnVal = new HashMap<>();

        returnVal.put("resultCode", 200);
        returnVal.put("data", tbboardList);
        return returnVal;
    }
    @GetMapping("/detail/{order}")
    public Map<String, Object> detail(@PathVariable String order){
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 0;
        int intOrder = 0;
        try{
            intOrder = Integer.parseInt(order);
            if(intOrder <= tbboardList.size() || intOrder > 0){
                returnVal.put("data", tbboardList.get(intOrder - 1));
                resultCode = 200;
            } else {
                resultCode = -2;
            }
        } catch (Exception e){
            resultCode = -1;
        }
        returnVal.put("resultCode", resultCode);
        //returnVal.put("data", tbboardList);
        return returnVal;
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        Map<String, Object> returnVal = new HashMap<>();
        String order = (String) params.get("order");
        int resultCode = 0;
        int intOrder = 0;
        try{
            intOrder = Integer.parseInt(order);
            if(intOrder <= tbboardList.size() || intOrder > 0){
                Map<String, Object> each = tbboardList.get(intOrder - 1);
                if(params.get("title") != null && !"".equals(params.get("title"))){
                    each.put("title", params.get("title"));
                }
                resultCode = 200;
            } else {
                resultCode = -2;
            }
        } catch (Exception e){
            resultCode = -1;
        }
        returnVal.put("resultCode", resultCode);
        //returnVal.put("data", tbboardList);
        return returnVal;
    }
}

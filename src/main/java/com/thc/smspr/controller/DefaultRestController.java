package com.thc.smspr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class DefaultRestController {

    //2024-07-09
    @GetMapping("/index")
    public String index(@RequestParam int test1, @RequestParam int test2){
        return "hahah!!! " + test1 + "///" + test2;
    }
    @GetMapping("/add")
    public String add(@RequestParam int test1, @RequestParam int test2){
        int result = test1 + test2;

        return "result : " + result;
    }
    @GetMapping("/login")
    public boolean login(@RequestParam String id, @RequestParam String pw){
        boolean result = false;
        System.out.println("id : " + id + "// pw" + pw);
        if("admin".equals(id)){
            if("abcd1234".equals(pw)){
                result = true;
            }
        }

        return result;
    }
    @GetMapping("/login2")
    public Map<String, Object> login2(@RequestParam Map<String, Object> params){
        Map<String, Object> returnData = new HashMap<String, Object>();
        boolean result = false;
        String msg = "";
        String id = (String) params.get("id");
        String pw = (String) params.get("pw");
        System.out.println("id : " + id + "// pw" + pw);
        if("admin".equals(id)){
            if("abcd1234".equals(pw)){
                result = true;
                msg = "정상 로그인 완료!";
            } else {
                msg = "pw 모르면 ㄴㄴ!!";
            }
        } else {
            msg = "id도 모르니?";
        }

        returnData.put("result", result);
        returnData.put("msg", msg);


        return returnData;
    }

    // 2024-07-10
    @GetMapping("/ajaxTest")
    public String ajaxTest(@RequestParam int test1){
        return "hahah!!! " + test1;
    }
    @GetMapping("/addTest")
    public Map<String, Object> addTest(
            @RequestParam int add1
            , @RequestParam int add2
    ){
        List<String> alist = new ArrayList<String>();
        alist.add("111");
        alist.add("112");
        alist.add("113");
        Map<String, Object> returnVal = new HashMap<>();

        int result = add1 + add2;
        returnVal.put("code", 200);
        returnVal.put("sum", result);
        returnVal.put("list", alist);
        return returnVal;
    }

}

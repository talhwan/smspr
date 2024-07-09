package com.thc.smspr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("")
@Controller
public class DefaultPageController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }


}

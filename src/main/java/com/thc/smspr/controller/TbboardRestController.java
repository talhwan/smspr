package com.thc.smspr.controller;

import com.thc.smspr.domain.Tbboard;
import com.thc.smspr.domain.Tbpost;
import com.thc.smspr.repository.TbboardRepository;
import com.thc.smspr.service.TbboardService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/tbboard")
@RestController
public class TbboardRestController {

    TbboardService tbboardService;
    public TbboardRestController(
            TbboardService tbboardService
    ){
        this.tbboardService = tbboardService;
    }

    @GetMapping("/create")
    public Map<String, Object> create(
            @RequestParam String title
            , @RequestParam String content
            , @RequestParam String writer
    ){
        Map<String, Object> tbboard = new HashMap<>();
        tbboard.put("title", title);
        tbboard.put("content", content);
        tbboard.put("writer", writer);
        return tbboardService.create(tbboard);
    }
    @GetMapping("/list")
    public Map<String, Object> list(){
        return tbboardService.list();
    }
    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable String id){
        return tbboardService.detail(id);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return tbboardService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return tbboardService.delete(params.get("id") + "");
    }
}

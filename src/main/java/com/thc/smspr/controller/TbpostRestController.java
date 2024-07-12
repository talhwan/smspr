package com.thc.smspr.controller;

import com.thc.smspr.domain.Tbpost;
import com.thc.smspr.repository.TbpostRepository;
import com.thc.smspr.service.TbpostService;
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

    //List<Map<String, Object>> tbpostList = new ArrayList<>();

    //private final TbpostRepository tbpostRepository;
    private final TbpostService tbpostService;
    public TbpostRestController(
            //TbpostRepository tbpostRepository,
            TbpostService tbpostService
    ) {
        //this.tbpostRepository = tbpostRepository;
        this.tbpostService = tbpostService;
    }

    //2024-07-10
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam String title, @RequestParam String content){
        /*Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 0;
        String resultData = "";
        String title = params.get("title") + "";
        String content = params.get("content") + "";
        if("".equals(title) || "null".equals(title)){
            resultCode = -100;
        } else if("".equals(content) || "null".equals(content)){
            resultCode = -200;
        } else {
            resultCode = 200;
            Map<String, Object> tbpostMap = new HashMap<String, Object>();
            //tbpostMap.put("order", tbpostList.size() + 1);
            tbpostMap.put("title", title);
            tbpostMap.put("content", content);
            //tbpostList.add(tbpostMap);
            Tbpost tbpost = Tbpost.of(title, content);
            tbpostRepository.save(tbpost);
            resultData = tbpost.getId();
        }

        returnData.put("resultCode", resultCode);
        returnData.put("resultData", resultData);*/
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", title);
        params.put("content", content);
        return tbpostService.create(params);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        /*
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 0;
        String resultData = "";
        String id = params.get("id") + "";
        Tbpost tbpost = tbpostRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        String title = params.get("title") + "";
        String content = params.get("content") + "";

        System.out.println("params : " + params);

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
        tbpostRepository.save(tbpost);
        returnData.put("resultCode", resultCode);
        */

        return tbpostService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        /*
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;
        String resultData = "";
        String id = params.get("id") + "";
        Tbpost tbpost = tbpostRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        tbpostRepository.delete(tbpost);

        returnData.put("resultCode", resultCode);
        */
        return tbpostService.delete(params.get("id") + "");
    }
    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam Map<String, Object> params){
        /*
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;
        returnData.put("resultCode", resultCode);
        //returnData.put("data", tbpostList);
        //returnData.put("resultData", tbpostRepository.findAll());
         */
        String title = (String) params.get("title");
        return tbpostService.list(title);
    }
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam String id){
        /*Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 200;
        returnData.put("resultCode", resultCode);
        //returnData.put("data", tbpostList);

        //Tbpost tbpost = tbpostRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        //returnData.put("resultData", tbpost);*/


        return tbpostService.detail(id);
    }


}

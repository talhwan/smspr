package com.thc.smspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tbboard")
@Controller
public class TbboardPageController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "tbboard/" + page;
    }

}

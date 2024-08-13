package com.jyy.riskctrl.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test() {
        return "this  is junit5 mock test";
    }
}

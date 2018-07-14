package com.springcloud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghonglan on 2018/6/20.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "eat apple";
    }
}

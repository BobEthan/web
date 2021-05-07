package com.caoy.web.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/web")
public class WebApplicationController {

    @GetMapping("test")
    public String test(){
        return "12341";
    }
}

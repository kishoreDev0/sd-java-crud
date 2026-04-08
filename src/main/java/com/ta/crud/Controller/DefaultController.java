package com.ta.crud.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping()
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    
}

package com.springcloud.eurekaprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Value("${server.port}")
    String port;

    @GetMapping("/getHi")
    public String getHi(){

        return "Hi" + "我的port是" + port;
    }
}

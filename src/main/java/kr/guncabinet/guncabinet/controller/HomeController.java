package kr.guncabinet.guncabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() { return "home"; }

    @GetMapping("/weapon/form")
    @ResponseBody
    public String about() { return "Here you can find some details for logged users"; }

}

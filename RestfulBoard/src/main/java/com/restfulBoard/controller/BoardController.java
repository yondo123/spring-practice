package com.restfulBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @GetMapping("/board")
    public String board(){
        return "board";
    }
}

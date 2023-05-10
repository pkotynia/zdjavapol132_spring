package com.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/questions")
public class InterviewQuestionsController {

    //private InterviewQuestionsRepository repository;

    // this is a test mapping, not a part of Interview Questions app
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Adele");
        return "hello";
    }

    @GetMapping("/new")
    public String questionInput() {
        return "input";
    }

    @PostMapping("/submit")
    public String submit(Model model,
                         @RequestParam String question,
                         @RequestParam String answer) {
        // todo save to repo

        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        return "result";
    }
}

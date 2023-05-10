package com.sda.demo.controller;

import com.sda.demo.model.InterviewQuestion;
import com.sda.demo.repository.InterviewQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/questions")
public class InterviewQuestionsController {

    private InterviewQuestionsRepository repository;

    public InterviewQuestionsController(InterviewQuestionsRepository repository) {
        this.repository = repository;
    }

    // this is a test mapping, not a part of Interview Questions app
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("questions", repository.findAll());
        return "view_all";
    }

    @GetMapping("/delete")
    public String getDeleteView() {
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String resourceId, Model model){
        repository.deleteById(Long.valueOf(resourceId));
        model.addAttribute("questions", repository.findAll());
        return "view_all";
    }

    @GetMapping("/new")
    public String questionInput() {
        return "input";
    }

    @PostMapping("/submit")
    public String submit(Model model,
                         @RequestParam String question,
                         @RequestParam String answer) {

        InterviewQuestion savedQuestion = repository.save(new InterviewQuestion(question, answer));

        model.addAttribute("question_id", savedQuestion.getQuestionId());
        model.addAttribute("question", savedQuestion.getQuestion());
        model.addAttribute("answer", savedQuestion.getAnswer());
        return "result";
    }
}

package com.example.coursework_3.controller;

import com.example.coursework_3.model.Question;
import com.example.coursework_3.service.JavaQuestionService;
import com.example.coursework_3.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/getQue")
    public Collection<Question> getAll(){
        return this.javaQuestionService.getAll();
    }


    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return this.javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {

        Question question1 = new Question(question,answer);
        return this.javaQuestionService.remove(question1);
    }

}

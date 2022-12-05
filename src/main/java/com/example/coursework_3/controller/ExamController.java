package com.example.coursework_3.controller;

import com.example.coursework_3.exeption.UnSufficientQuestionsException;
import com.example.coursework_3.model.Question;
import com.example.coursework_3.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExamService examService;

    @ExceptionHandler(UnSufficientQuestionsException.class)
    public ResponseEntity<String>handlerException(){
        return ResponseEntity.badRequest().body("Мало вопросов");
    }

    public ExamController(ExamService examService) {
        this.examService = examService;
    }


    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examService.getQuestions(amount);
    }
}

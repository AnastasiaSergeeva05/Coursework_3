package com.example.coursework_3.service;

import com.example.coursework_3.exeption.UnSufficientQuestionsException;
import com.example.coursework_3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExamServiceImp implements ExamService {
    private final QuestionService questionService;

    public ExamServiceImp(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new UnSufficientQuestionsException();
        }
        while (questions.size()<amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}

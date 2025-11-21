package com.codequiz.codequiz.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codequiz.codequiz.model.QuestionModel;
import com.codequiz.codequiz.service.QuestionsService;
@RestController
@RequestMapping("/api/questions")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @GetMapping("/all-questions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions()
    {
        return questionsService.getAllQuestions();

    }
    @GetMapping("/{category}")
    public ResponseEntity<?> getByCategory(@PathVariable String category)
    {
        
        return questionsService.getByCategory(category);

    }
}

package com.codequiz.codequiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.codequiz.codequiz.model.QuestionWrraper;
import com.codequiz.codequiz.model.Response;
import com.codequiz.codequiz.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    QuizService quizservice;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String tittle)
    {
        return quizservice.createQuiz(category,numQ,tittle);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrraper>> getQuizQuestions(@PathVariable Integer id)
    {
        return quizservice.getQuizQuestions(id);

    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitAnswers(Integer id,@RequestParam List<Response> responses)
    {
        return quizservice.submitAnswers(id,responses);

    }
}

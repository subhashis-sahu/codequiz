package com.codequiz.codequiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codequiz.codequiz.model.QuestionModel;
import com.codequiz.codequiz.repo.QuestionsRepo;

@Service
public class QuestionsService {

    @Autowired
    QuestionsRepo questionsRepo;
    public ResponseEntity<List<QuestionModel>> getAllQuestions() {
        return new ResponseEntity<>(questionsRepo.findAll(),HttpStatus.OK);
        
        
    }
    public ResponseEntity<?> getByCategory(String category) {
        
        return new ResponseEntity<>(questionsRepo.findByCategory(category),HttpStatus.OK);
    }
    
}

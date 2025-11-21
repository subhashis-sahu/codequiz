package com.codequiz.codequiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codequiz.codequiz.model.QuizModel;

@Repository
public interface QuizRepo extends JpaRepository<QuizModel,Integer> {
    
}

package com.codequiz.codequiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codequiz.codequiz.model.QuestionModel;

@Repository
public interface QuestionsRepo extends JpaRepository<QuestionModel,Integer> {
    List<QuestionModel> findByCategory(String category);

    @Query(value = "select * from question_model q where q.category=:category ORDER BY RANDOM() Limit :numQ",nativeQuery = true)
    List<QuestionModel> findRandomQuestionsByCategory(String category, int numQ);
    
}

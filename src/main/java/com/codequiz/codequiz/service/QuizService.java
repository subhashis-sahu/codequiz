package com.codequiz.codequiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codequiz.codequiz.model.QuestionModel;
import com.codequiz.codequiz.model.QuestionWrraper;
import com.codequiz.codequiz.model.QuizModel;
import com.codequiz.codequiz.model.Response;
import com.codequiz.codequiz.repo.QuestionsRepo;
import com.codequiz.codequiz.repo.QuizRepo;

@Service
public class QuizService {

    @Autowired 
    QuizRepo quizRepo;


    @Autowired
    QuestionsRepo questionsRepo;
    public ResponseEntity<String> createQuiz(String category, int numQ, String tittle) {
        List<QuestionModel> questions=questionsRepo.findRandomQuestionsByCategory(category,numQ);
        QuizModel quiz=new QuizModel();
        quiz.setTittle(tittle);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("creted",HttpStatus.CREATED);

    }
    public ResponseEntity<List<QuestionWrraper>> getQuizQuestions(Integer id) {
        Optional<QuizModel> quiz=quizRepo.findById(id);
        List<QuestionModel> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrraper> questionForUser=new ArrayList<>();


        for(QuestionModel q:questionsFromDB)
        {
            QuestionWrraper qw=new QuestionWrraper(q.getId(), q.getQuestionsTittle(), q.getOptions1(), q.getOptions2(), q.getOptions3(), q.getOptions4());

            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }
    public ResponseEntity<Integer> submitAnswers(Integer id, List<Response> responses) {
        QuizModel quizModel=quizRepo.findById(id).get();
        List<QuestionModel> questions=quizModel.getQuestions();

        int result=0;
        int i=0;
        for(Response response:responses)
        {
            if (response.getResponse().equals(questions.get(i).getRightAnswer())) {
                result++;
                
            }
            i++;
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}

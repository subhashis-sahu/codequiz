package com.codequiz.codequiz.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionsTittle;
    private String options1;
    private String options2;
    private String options3;
    private String options4;

    private String rightAnswer;
    private String difficultyLevel;
    private String category;

}

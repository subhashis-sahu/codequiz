package com.codequiz.codequiz.model;

import lombok.Data;

@Data
public class QuestionWrraper {
    private Integer id;
    private String questionsTittle;
    private String options1;
    private String options2;
    private String options3;
    private String options4;
    public QuestionWrraper(Integer id, String questionsTittle, String options1, String options2, String options3,
            String options4) {
        this.id = id;
        this.questionsTittle = questionsTittle;
        this.options1 = options1;
        this.options2 = options2;
        this.options3 = options3;
        this.options4 = options4;
    }

    

    
}

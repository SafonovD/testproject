package com.newcompany.test.company.test.dto;

import com.newcompany.test.company.test.model.Questions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsDto {

    private String question_name;

    public Questions toQuestions() {
        Questions questions = new Questions();
        questions.setName(question_name);
        return questions;
    }

    public static QuestionsDto fromUQuestions(Questions questions) {
        QuestionsDto questionsDto = new QuestionsDto();;
        questionsDto.setQuestion_name(questions.getName());
        return questionsDto;
    }
}

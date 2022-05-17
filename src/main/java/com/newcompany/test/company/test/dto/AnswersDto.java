package com.newcompany.test.company.test.dto;

import com.newcompany.test.company.test.model.Answers;
import com.newcompany.test.company.test.model.Questions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswersDto {

    private String answer_name;
    public boolean correctAnswerOfQuestion;
//    private Long questions_id;


    public Answers toAnswers() {
        Answers answers = new Answers();
        answers.setName(answer_name);
        answers.setCorrectAnswerOfQuestion(correctAnswerOfQuestion);
//        answers.setQuestions_id(questions_id);
        return answers;
    }

    public static AnswersDto fromAnswer(Answers answers) {
        AnswersDto answersDto = new AnswersDto();
        answersDto.setAnswer_name(answers.getName());
        answersDto.setCorrectAnswerOfQuestion(answers.isCorrectAnswerOfQuestion());
//        answersDto.setQuestions_id(answers.getQuestions_id());
        return answersDto;
    }

}

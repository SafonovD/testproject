package com.newcompany.test.company.test.dto;


import liquibase.repackaged.com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsAndAnswersDto {

    @CsvBindByName(column = "Question")
    private String question;
    @CsvBindByName(column = "Answer")
    private String answer;
    @CsvBindByName(column = "CorrectAnswer")
    private boolean correctAnswer;



}

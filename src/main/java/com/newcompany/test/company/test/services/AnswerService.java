package com.newcompany.test.company.test.services;

import com.newcompany.test.company.test.dto.AnswersDto;
import com.newcompany.test.company.test.model.Answers;

import java.util.List;

public interface AnswerService {

    void insertAnswer(Integer questionId, AnswersDto answersDto);

    Answers findByName(String name);

    List<Answers> getAll();

    Answers findById(Long id);
}

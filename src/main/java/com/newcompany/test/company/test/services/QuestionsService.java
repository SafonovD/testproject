package com.newcompany.test.company.test.services;

import com.newcompany.test.company.test.dto.QuestionsDto;
import com.newcompany.test.company.test.model.Questions;

import java.util.List;
import java.util.Optional;

public interface QuestionsService {

    Optional<Integer> insertQuestions(QuestionsDto questions);

    List<Questions> getAll();

}

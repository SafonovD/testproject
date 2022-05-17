package com.newcompany.test.company.test.services.impl;

import com.newcompany.test.company.test.dto.QuestionsDto;
import com.newcompany.test.company.test.model.Questions;
import com.newcompany.test.company.test.repositories.QuestionsRepository;
import com.newcompany.test.company.test.services.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsRepository questionsRepository;

    public Optional<Integer> insertQuestions(QuestionsDto questionsDto) {

        final String questionsName = questionsDto.getQuestion_name();
        if (StringUtils.isBlank(questionsName)) {
            return Optional.empty();
        }
        Questions questions = questionsDto.toQuestions();
        questionsRepository.save(questions);

        final Questions result = questionsRepository.findByName(questionsName);
        String idString = String.valueOf(result.getId());
        Integer id = Integer.valueOf(idString);

        return Optional.of(id);

    }

    @Override
    public List<Questions> getAll() {
        return questionsRepository.findAll();
    }
}
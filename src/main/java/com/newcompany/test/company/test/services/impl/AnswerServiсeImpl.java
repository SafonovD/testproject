package com.newcompany.test.company.test.services.impl;

import com.newcompany.test.company.test.dto.AnswersDto;
import com.newcompany.test.company.test.model.Answers;
import com.newcompany.test.company.test.repositories.AnswerRepository;
import com.newcompany.test.company.test.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiсeImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    private Long questID;

    @Override
    public void insertAnswer(Integer questionId, AnswersDto answersDto) {
        Answers answer = new Answers();

        if (questionId != null) {

            answer.setName(answersDto.getAnswer_name());
            answer.setCorrectAnswerOfQuestion(answersDto.isCorrectAnswerOfQuestion());
            questID=Long.valueOf(questionId);
            answer.setQuestions_id(questID);
            answerRepository.save(answer);
        } else {
            answer.setName(answersDto.getAnswer_name());
            answer.setCorrectAnswerOfQuestion(answersDto.isCorrectAnswerOfQuestion());
            answer.setQuestions_id(questID);

            answerRepository.save(answer);
        }
    }

    @Override
    public Answers findByName(String name) {
        Answers answers = answerRepository.findByName(name);
        return answers;
    }

    @Override
    public List<Answers> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answers findById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }
}
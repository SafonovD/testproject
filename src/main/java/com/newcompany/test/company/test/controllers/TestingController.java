package com.newcompany.test.company.test.controllers;

import com.newcompany.test.company.test.model.Answers;
import com.newcompany.test.company.test.model.Questions;
import com.newcompany.test.company.test.services.AnswerService;
import com.newcompany.test.company.test.services.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestingController {

    private final QuestionsService questionsService;
    private final AnswerService answerService;

    @GetMapping
    public String testList(Model model){

        List<Questions> questions = questionsService.getAll();
        final List<Questions> collectQuest = questions.stream().limit(1).collect(Collectors.toList());

        model.addAttribute("questions", collectQuest);
        model.addAttribute("answers", answerService.getAll());
        return "testList";
    }

//    @PostMapping("/test/start/{ans}")
//    public String startTest(@RequestBody("ans")Long answerId){
//        Answers answer = answerService.findById(answerId);
//        if(!answer.isCorrectAnswerOfQuestion()){
//
//            return "result";
//        }
//
//        return "result";
//    }

}

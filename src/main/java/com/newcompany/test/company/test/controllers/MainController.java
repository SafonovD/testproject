package com.newcompany.test.company.test.controllers;

import com.newcompany.test.company.test.dto.AnswersDto;
import com.newcompany.test.company.test.dto.QuestionsAndAnswersDto;
import com.newcompany.test.company.test.dto.QuestionsDto;
import com.newcompany.test.company.test.services.AnswerService;
import com.newcompany.test.company.test.services.QuestionsService;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final AnswerService answerService;
    private final QuestionsService questionsService;

    Collection<QuestionsAndAnswersDto> questionsAndAnswersDtos = null;

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:index";
    }

    @GetMapping("/admin")
    public String showAdminPage(){
        return "admin";
    }

    @PostMapping("/admin")
    public String pageForAdmin(@RequestParam("file") MultipartFile file,Model model) {
        if (file == null) {
            model.addAttribute("message", "Выберите CSV file для загрузки.");
            model.addAttribute("status", false);
        } else {
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CsvToBean<QuestionsAndAnswersDto> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(QuestionsAndAnswersDto.class)
                        .withSeparator(';')
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                questionsAndAnswersDtos = csvToBean.stream().collect(Collectors.toList());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        questionsAndAnswersDtos.stream().map(questionsAndAnswersDto -> Pair.of(
                new QuestionsDto(questionsAndAnswersDto.getQuestion()),
                new AnswersDto(questionsAndAnswersDto.getAnswer(),questionsAndAnswersDto.isCorrectAnswer())))
                .forEach(pair ->
        {
            final Optional<Integer> question = questionsService.insertQuestions(pair.getLeft());
            answerService.insertAnswer(question.orElse(null), pair.getRight());
        });

        return "admin";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}

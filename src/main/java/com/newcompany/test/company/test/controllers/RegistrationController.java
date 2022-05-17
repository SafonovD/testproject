package com.newcompany.test.company.test.controllers;

import com.newcompany.test.company.test.dto.UserRegistrationDto;
import com.newcompany.test.company.test.repositories.UserRepository;

import com.newcompany.test.company.test.services.SecurityService;
import com.newcompany.test.company.test.services.UserService;
import com.newcompany.test.company.test.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final UserValidator userValidator;
    private final UserService userService;
    private final SecurityService securityService;

    @ModelAttribute("userDto")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute("userDto") UserRegistrationDto userDto, BindingResult bindingResult){
        userValidator.validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userDto.toUser());
        securityService.autoLogin(userDto.getUsername(), userDto.getConfirmPassword());
        return "redirect:/index";
    }
}

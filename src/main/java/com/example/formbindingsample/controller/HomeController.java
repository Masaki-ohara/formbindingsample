package com.example.formbindingsample.controller;

import com.example.formbindingsample.dto.UserInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("userInput", new UserInput());
        return "input";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute UserInput userInput) {
        // AccountとPasswordのチェック
        if (userInput.getAccount().equals("slstudio") &&
                userInput.getPassword().equals("password")) {
            return "success";
        }
        return "input";
    }
}

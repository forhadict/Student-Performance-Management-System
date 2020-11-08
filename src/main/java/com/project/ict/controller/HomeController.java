package com.project.ict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String Home(Model model, HttpSession session) {
        SessionController.KeepSession(session);

        model.addAttribute("cssLinkPrefix", "");
        return "index";
    }
}


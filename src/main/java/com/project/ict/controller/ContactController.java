package com.project.ict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ContactController {

    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping(value="/contact")
    public String Contact(Model model, HttpSession session, HttpServletRequest request, @RequestParam(required = false, value = "submit") String submit) throws IOException, MessagingException {
        SessionController.KeepSession(session);

        if (request.getMethod().equals("POST")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String subject = request.getParameter("subject");
            String message = request.getParameter("message");

            MimeMessage msg = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo("rakib.cse14th@gmail.com");
            helper.setSubject(subject);
            helper.setText(
                    "<h5 style=\"color:red\">"+name+"</h4>\n" +
                    "<h5 style=\"color:blue\">"+email+"</h5>\n" +
                    "<p>"+message+"</p>",
                    true);

            try {javaMailSender.send(msg);}
            catch(Exception e) { }
        }

        model.addAttribute("cssLinkPrefix", "");
        return "contact";
    }
}

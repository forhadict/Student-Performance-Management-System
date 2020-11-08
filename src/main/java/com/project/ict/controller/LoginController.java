package com.project.ict.controller;

import com.project.ict.view.LoginView;
import com.project.ict.pojo.StudentIntro;
import com.project.ict.pojo.TeacherIntro;
import com.project.ict.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public String Login(Model model, HttpSession session, HttpServletRequest request, @RequestParam(required = false, value = "submit") String submit) throws NullPointerException {
        SessionController.KeepSession(session);

        if (session.getAttribute("loginType") != null) {
            model.addAttribute("cssLinkPrefix", "");
            return "index";
        }

        if (request.getMethod().equals("POST")) {
            String loginType = request.getParameter("loginType");
            String username = request.getParameter("username").trim().toLowerCase();
            String password = request.getParameter("password");

            if (loginType.equalsIgnoreCase("Student")) {
                StudentIntro studentIntro = new StudentIntro();
                try {studentIntro = loginService.studentLogin(username, password);}
                catch (Exception e) { }

                String uname = studentIntro.getUsername();
                String name = studentIntro.getName();
                String batch = studentIntro.getBatch();
                byte[] image = studentIntro.getImage();
                String result = studentIntro.getResult();
                if (result.equalsIgnoreCase("loginSuccess")) {
                    session.setAttribute("loginLogoutUrl", LoginView.LogoutButtonUrl());
                    session.setAttribute("loginLogoutIcon", LoginView.LogoutButtonIcon());
                    session.setAttribute("loginLogoutText", LoginView.LogoutButtonText());

                    model.addAttribute("loginStatus", LoginView.LoginStatus("Successfully logged in as student.", "mediumseagreen"));
                    session.setAttribute("loginType", "student");
                    String studentImage = Base64.getEncoder().encodeToString(image);
                    session.setAttribute("loginImage", studentImage);
                    session.setAttribute("loginUsername", uname);
                    model.addAttribute("cssLinkPrefix", "");
                    return "index";
                }
                if (result.equalsIgnoreCase("incorrectPassword")) {
                    model.addAttribute("loginStatus", LoginView.LoginStatus("Password is incorrect.", "red"));
                }
                if (result.equalsIgnoreCase("noDataFound")) {
                    model.addAttribute("loginStatus", LoginView.LoginStatus("You must register first as student.", "red"));
                }
            } else if (loginType.equalsIgnoreCase("Teacher")) {
                TeacherIntro teacherIntro = new TeacherIntro();
                try {teacherIntro = loginService.teacherLogin(username, password);}
                catch (Exception e) { }

                String uname = teacherIntro.getUsername();
                String name = teacherIntro.getName();
                String designation = teacherIntro.getDesignation();
                byte[] image = teacherIntro.getImage();
                String result = teacherIntro.getResult();
                if (result.equalsIgnoreCase("loginSuccess")) {
                    session.setAttribute("loginLogoutUrl", LoginView.LogoutButtonUrl());
                    session.setAttribute("loginLogoutIcon", LoginView.LogoutButtonIcon());
                    session.setAttribute("loginLogoutText", LoginView.LogoutButtonText());

                    model.addAttribute("loginStatus", LoginView.LoginStatus("Successfully logged in as teacher.", "mediumseagreen"));
                    session.setAttribute("loginType", "teacher");
                    String teacherImage = Base64.getEncoder().encodeToString(image);
                    session.setAttribute("loginImage", teacherImage);
                    session.setAttribute("loginUsername", uname);
                    model.addAttribute("cssLinkPrefix", "");
                    return "index";
                }
                if (result.equalsIgnoreCase("incorrectPassword")) {
                    model.addAttribute("loginStatus", LoginView.LoginStatus("Password is incorrect.", "red"));
                }
                if (result.equalsIgnoreCase("noDataFound")) {
                    model.addAttribute("loginStatus", LoginView.LoginStatus("You must register first as teacher.", "red"));
                }
            } else {
                model.addAttribute("loginStatus", LoginView.LoginStatus("Please select a login type.", "red"));
            }
        }

        model.addAttribute("cssLinkPrefix", "");
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String Logout(Model model, HttpSession session, HttpServletRequest request, @RequestParam(required = false, value = "submit") String submit) throws NullPointerException {
        SessionController.KeepSession(session);

        if (session.getAttribute("loginType") != null) {
            session.removeAttribute("loginType");
            session.removeAttribute("loginImage");
            session.removeAttribute("loginUsername");
            session.setAttribute("loginLogoutUrl", LoginView.LoginButtonUrl());
            session.setAttribute("loginLogoutIcon", LoginView.LoginButtonIcon());
            session.setAttribute("loginLogoutText", LoginView.LoginButtonText());
            model.addAttribute("cssLinkPrefix", "");
            return "login";
        }
        else {
            model.addAttribute("cssLinkPrefix", "");
            return "index";
        }
    }
}

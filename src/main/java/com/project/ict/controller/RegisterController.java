package com.project.ict.controller;

import com.project.ict.view.RegisterView;
import com.project.ict.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    
    private String sidPrefix(String dept) {
        String idPrefix = null;
        if (dept.equals("CSE")) {
            idPrefix = "CE";
        }
        else if (dept.equals("ICT")) {
            idPrefix = "IT";
        }
        else if (dept.equals("TE")) {
            idPrefix = "TE";
        }
        else if (dept.equals("Mathematics")) {
            idPrefix = "MATH";
        }
        else if (dept.equals("Chemistry")) {
            idPrefix = "CHEM";
        }
        else if (dept.equals("Physics")) {
            idPrefix = "PHY";
        }
        else if (dept.equals("Statistics")) {
            idPrefix = "STAT";
        }
        else if (dept.equals("Pharmacy")) {
            idPrefix = "PHAR";
        }
        else if (dept.equals("BGE")) {
            idPrefix = "BGE";
        }
        else if (dept.equals("BMB")) {
            idPrefix = "BMB";
        }
        else if (dept.equals("FTNS")) {
            idPrefix = "FTNS";
        }
        else if (dept.equals("ESRM")) {
            idPrefix = "ESRM";
        }
        else if (dept.equals("CPS")) {
            idPrefix = "CPS";
        }
        else if (dept.equals("Business Administration")) {
            idPrefix = "BBA";
        }
        else if (dept.equals("Management")) {
            idPrefix = "MAN";
        }
        else if (dept.equals("Accounting")) {
            idPrefix = "ACC";
        }
        else if (dept.equals("Economics")) {
            idPrefix = "ECO";
        }

        return idPrefix;
    }

    @RequestMapping(value="/register")
    public String Register(Model model, HttpSession session, HttpServletRequest request, @RequestParam(required = false, value = "submit") String submit) throws ParseException, IOException {
        SessionController.KeepSession(session);
        if (session.getAttribute("loginType") != null) {
            model.addAttribute("cssLinkPrefix", "");
            return "index";
        }

        if (request.getMethod().equals("POST")) {
            String regiType = request.getParameter("regiType");
            String sid = request.getParameter("sid");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String bloodGroup = request.getParameter("bloodGroup");

            String imagePath = "static/css/img/blog/account.png";
            ClassPathResource imgFile = new ClassPathResource(imagePath);
            byte[] image = StreamUtils.copyToByteArray(imgFile.getInputStream());

            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String faculty = request.getParameter("faculty");
            String dept = request.getParameter("dept");
            sid = sidPrefix(dept) + "-" + sid;
            String batch = request.getParameter("batch");
            String Asession = request.getParameter("session");
            String doj = request.getParameter("doj");
            String designation = request.getParameter("designation");
            String username = request.getParameter("username").toLowerCase();
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            String result = null;

            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            //Date d = simpleDateFormat.parse(dob);

            if (password.equals(confirmPassword)) {
                if (regiType.equals("Teacher")) {
                    try {result = registerService.insertTeacherDetails(doj, name.trim(), dob, bloodGroup, image, email.trim(), phone, faculty, dept, designation, username.trim(), password);}
                    catch (Exception e) { }

                    if (result.equals("success")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("Successfully registered as a Teacher.", "mediumseagreen"));
                    }
                    if (result.equals("duplicateUsername")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("This username already taken by another teacher...!", "red"));
                    }
                    if (result.equals("duplicateEmail")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("This email already used by another teacher...!", "red"));
                    }
                    if (result.equals("duplicatePhone")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("This phone already used by another teacher...!", "red"));
                    }
                }

                if (regiType.equals("Student")) {
                    try {result = registerService.insertStudentDetails(sid, name.trim(), dob, bloodGroup, image, email.trim(), phone, faculty, dept, batch, Asession, doj, username.trim(), password);}
                    catch (Exception e) { }

                    if (result.equals("success")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("Successfully registered as a Student.", "mediumseagreen"));
                    }
                    if (result.equals("duplicateSid")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("This Student ID already taken by another student...!", "red"));
                    }
                    if (result.equals("duplicateUsername")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("This username already taken by another student...!", "red"));
                    }
                    if (result.equals("duplicateEmail")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("This email already used by another student...!", "red"));
                    }
                    if (result.equals("duplicatePhone")) {
                        model.addAttribute("registerStatus", RegisterView.RegisterStatus("This phone already used by another student...!", "red"));
                    }
                }
            }
            else {
                model.addAttribute("registerStatus", RegisterView.RegisterStatus("Password do not match.", "red"));
            }
        }

        model.addAttribute("cssLinkPrefix", "");
        return "register";
    }
}

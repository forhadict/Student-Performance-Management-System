package com.project.ict.controller;

import com.project.ict.view.AccountView;
import com.project.ict.pojo.*;
import com.project.ict.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    private static String sid;
    private static String name;
    private static String designation;
    private static String degree;
    private static String dob;
    private static String bloodGroup;
    private static String image;
    private static String email;
    private static String phone;
    private static String faculty;
    private static String dept;
    private static String batch;
    private static String sess;
    private static String doj;
    private static String about;
    private static String homeAddress;
    private static String currentAddress;
    private static String result;

    private static ArrayList<StudentInfo> studentInfoArrayList = null;
    private static String studentInfoSession = null;
    private static String studentInfoCourseCode = null;
    private static int teacherTotalClass = 0;
    private static ExamStatus examStatus = null;

    public static String CourseTittle (String courseCode) {
        Map<String, String> mp = new HashMap<String, String>();
        mp.put("CSE-1101", " Computer Basics and Programming Fundamentals ");
        mp.put("CSE-1102", " Computer Basics and Programming Fundamentals Lab ");
        mp.put("CSE-1103", " Electrical Circuit Analysis ");
        mp.put("CSE-1104", " Electrical Circuit Analysis Lab ");
        mp.put("CSE-1105", " Mathematics 1");
        mp.put("CSE-1107", " English ");
        mp.put("CSE-1109", " Economics and Sociology ");

        mp.put("CSE1201", " Electronics Devices and Circuits ");
        mp.put("CSE-1202", " Electronics Devices and Circuits Lab ");
        mp.put("CSE-1203", " Structured Programming ");
        mp.put("CSE-1204", " Structured Programming Lab ");
        mp.put("CSE-1205", " Discrete Mathematics ");
        mp.put("CSE-1207", " Physics ");
        mp.put("CSE-1209", " Chemistry ");
        mp.put("CSE-1211", " Mathematics 2 ");

        mp.put("CSE-2101", " Object oriented Programming");
        mp.put("CSE-2102", " Object oriented Programming Lab ");
        mp.put("CSE-2103", " Data Structures ");
        mp.put("CSE-2104", " Data Structures Lab ");
        mp.put("CSE-2105", " Digital Electronics ");
        mp.put("CSE-2106", " Digital Electronics Lab ");
        mp.put("CSE-2107", " Mathematics 3 ");
        mp.put("CSE-2109", " Statistics ");
        mp.put("CSE-2111", " Accounting ");
        mp.put("CSE-2112", " Software Development Project 1 and Industrial Tour");

        mp.put("CSE-2201", " Algorithms: Design and Analysis ");
        mp.put("CSE-2202", " Algorithms: Design and Analysis Lab ");
        mp.put("CSE-2203", " Computer Organization and Architecture ");
        mp.put("CSE-2205", " Computer Based Numerical Methods ");
        mp.put("CSE-2206", " Computer Based Numerical Methods Lab");
        mp.put("CSE-2207", " Object Oriented Analysis and Design ");
        mp.put("CSE-2208", " Object Oriented Analysis and Design  Lab");
        mp.put("CSE-2209", " Digital System Design ");
        mp.put("CSE-2210", " Digital System Design Lab ");
        mp.put("CSE-2211", " Mathematic 4");
        mp.put("CSE-2214", " Visual Programming Lab 1 ");
        mp.put("CSE-2216", " Visual Programming Lab 2 ");

        mp.put("CSE-3101", " Operating Systems ");
        mp.put("CSE-3102", " Operating Systems Lab ");
        mp.put("CSE-3103", " Microprocessors and Assembly Language ");
        mp.put("CSE-3104", " Microprocessors and Assembly Language Lab");
        mp.put("CSE-3105", " Database Management Systems ");
        mp.put("CSE-3106", " Database Management Systems  Lab");
        mp.put("CSE-3107", " Software Engineering ");
        mp.put("CSE-3109", " Data Communication ");
        mp.put("CSE-3110", " Data Communication Lab ");
        mp.put("CSE-3111", " Theory of Computing ");
        mp.put("CSE-3116", " Software Development Project 2 and Industrial Tour ");

        mp.put("CSE-3201", " Compiler Design ");
        mp.put("CSE-3202", " Compiler Design Lab ");
        mp.put("CSE-3203", " Computer Networks ");
        mp.put("CSE-3204", " Computer Networks Lab");
        mp.put("CSE-3205", " Computer Peripherals and Interfacing ");
        mp.put("CSE-3206", " Computer Peripherals and Interfacing Lab");
        mp.put("CSE-3208", " Relational Database Management Systems Lab ");
        mp.put("CSE-3209", " Multimedia and Web Engineering ");
        mp.put("CSE-3210", " Multimedia and Web Engineering Lab ");
        mp.put("CSE-3211", " Communication Engineering ");
        mp.put("CSE-4101", " Artificial Intelligence and Expert Systems ");
        mp.put("CSE-4102", " Artificial Intelligence and Expert Systems Lab ");
        mp.put("CSE-4103", " VLSI Design ");
        mp.put("CSE-4104", " VLSI Design Lab");
        mp.put("CSE-4105", " Digital Image Processing and Computer Vision");
        mp.put("CSE-4106", " Digital Image Processing and Computer Vision Lab");
        mp.put("CSE-4107", " Network Routing and Switching ");
        mp.put("CSE-4108", " Network Routing and Switching  Lab");
        mp.put("CSE-4113", " IT Organization and Management ");
        mp.put("CSE-4115", " Digital Image Processing ");
        mp.put("CSE-4116", "Digital Image Processing Lab ");
        mp.put("CSE-5000", " Research project ");

        mp.put("CSE-4201", "Computer Graphics and Animation ");
        mp.put("CSE-4202", "Computer Graphics and Animation Lab ");
        mp.put("CSE-4203", " Neural Networks and Fuzzy system");
        mp.put("CSE-4204", " Neural Networks and Fuzzy system Lab");
        mp.put("CSE-4205", " Simulation and Modeling ");
        mp.put("CSE-4206", " Simulation and Modeling Lab");
        mp.put("CSE-4207", " Data Mining ");
        mp.put("CSE-5000", " Research project ");

        mp.put("ICT-1101", " Basic Electrical Circuit");
        mp.put("ICT-1102", " Basic Electrical Circuit Lab ");
        mp.put("ICT-1103", " Computer Programming  ");
        mp.put("ICT-1104", " Computer Programming  Lab");
        mp.put("ICT-1105", " Physics ");
        mp.put("ICT-1107", " Differential and Integral Calculas");
        mp.put("ICT-1109", " Technical Communicative English ");
        mp.put("ICT-1110", " Technical Communicative English Lab ");
        mp.put("ICT-1111", " Technology, Environment and Society ");

        mp.put("ICT-1201", " Electronic Device and Circuit Theory ");
        mp.put("ICT-1202", " Electronic Device and Circuit Theory Lab ");
        mp.put("ICT-1203", " Programming With C++");
        mp.put("ICT-1204", " Programming With C++ Lab");
        mp.put("ICT-1205", " Data structure ");
        mp.put("ICT-1206", " Data structure Lab");
        mp.put("ICT-1207", " Discrete Mathematics ");
        mp.put("ICT-1209", " Geometry and Linear Algebra ");
        mp.put("ICT-1210", " Project ");
        mp.put("ICT-1211", " Bhashani Studies ");

        mp.put("ICT-2101", " Operational Amplifier and Timer Circuit ");
        mp.put("ICT-2102", " Operational Amplifier and Timer Circuit Lab ");
        mp.put("ICT-2103", " Digital Logic Design ");
        mp.put("ICT-2104", " Digital Logic Design Lab");
        mp.put("ICT-2105", " Object Oriented Programming With Java ");
        mp.put("ICT-2106", " Object Oriented Programming With Java Lab");
        mp.put("ICT-2107", " Algorithm Design and Analysis ");
        mp.put("ICT-2108", " Algorithm Design and Analysis  Lab");
        mp.put("ICT-2109", " Differential Equation and Vector Calculus ");
        mp.put("ICT-2111", " Economics ");

        mp.put("ICT-2201", " Signals and Systems ");
        mp.put("ICT-2202", " Signals and Systems Lab ");
        mp.put("ICT-2203", " Numerical Methods ");
        mp.put("ICT-2204", " Numerical Methods Lab");
        mp.put("ICT-2205", " Advanced Java and Mobile Application ");
        mp.put("ICT-2206", " Advanced Java and Mobile Application Lab");
        mp.put("ICT-2207", " Database Management Systems ");
        mp.put("ICT-2208", " Database Management Systems Lab");
        mp.put("ICT-2209", " Complex Variables and Fourier Analysis");
        mp.put("ICT-2211", " Statistics ");

        mp.put("ICT-3101", " Electromagnetic Fields and Waves");
        mp.put("ICT-3103", " Analog Communication ");
        mp.put("ICT-3104", " Analog Communication Lab");
        mp.put("ICT-3105", " Microprocessor and Assembly Language ");
        mp.put("ICT-3106", " Microprocessor and Assembly Language Lab");
        mp.put("ICT-3107", " Computer Organization and Architecture ");
        mp.put("ICT-3109", " Operating Systems ");
        mp.put("ICT-3110", " Operating Systems Lab ");
        mp.put("ICT-3111", " Financial and Managerial Accounting ");

        mp.put("ICT-3201", " Microwave Communication and Radar ");
        mp.put("ICT-3202", " Microwave Communication and Radar Lab ");
        mp.put("ICT-3203", " Digital Communication ");
        mp.put("ICT-3204", " Digital Communication Lab");
        mp.put("ICT-3205", " Computer Peripheral and Interfacing ");
        mp.put("ICT-3206", " Computer Peripheral and Interfacing Lab");
        mp.put("ICT-3207", " Computer Networks ");
        mp.put("ICT-3208", " Computer Planning and Designing Lab ");
        mp.put("ICT-3209", " Software Engineering ");
        mp.put("ICT-3210", " Software Engineering Lab");

        mp.put("ICT-4000", " Research Thesis/Project ");
        mp.put("ICT-4101", " Telecommunication Engineering ");
        mp.put("ICT-4103", " Digital Signal Processing ");
        mp.put("ICT-4104", " Digital Signal Processing Lab");
        mp.put("ICT-4105", " Network Security and Cyber Law ");
        mp.put("ICT-4107", " Internet and Web Programming ");
        mp.put("ICT-4108", " Internet and Web Programming Lab");
        mp.put("ICT-4110", " Research Methodology ");
        mp.put("ICT-4119", " Artificial Intelligence ");
        mp.put("ICT-4120", " Artificial Intelligence Lab");

        mp.put("ICT-4000", " Research Thesis/Project ");
        mp.put("ICT-4201", " Wireless and Mobile Communication ");
        mp.put("ICT-4202", " Wireless and Mobile Communication Lab");
        mp.put("ICT-4203", " Optical Communication ");
        mp.put("ICT-4204", " Optical Communication  Lab");
        mp.put("ICT-4205", " Simulation and Modeling");
        mp.put("ICT-4207", " Data Mining ");
        mp.put("ICT-4209", " Digital Image Processing ");
        mp.put("ICT-4210", " Digital Image Processing Lab");

        return mp.get(courseCode);
    }

    @RequestMapping(value="/{userType}/account/{username}")
    public String Account(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);

        String sessionUsername = (String) session.getAttribute("loginUsername");
        if (userType.equalsIgnoreCase("student")) {
            if (username.equalsIgnoreCase(sessionUsername)) {
                StudentData studentData = accountService.studentData(username);
                sid = studentData.getSid();
                name = studentData.getName();
                designation = "Student";
                degree = "B.Sc";
                dob = studentData.getDob();
                bloodGroup = studentData.getBloodGroup();
                byte [] imageByte = studentData.getImage();
                if (imageByte != null) image = Base64.getEncoder().encodeToString(imageByte);
                email = studentData.getEmail();
                phone = studentData.getPhone();
                dept = studentData.getDept();
                batch = studentData.getBatch();
                sess = studentData.getSession();
                doj = studentData.getDoj();
                about = studentData.getAbout();
                homeAddress = studentData.getHomeAddress();
                currentAddress = studentData.getCurrentAddress();
                result = studentData.getResult();

                model.addAttribute("name", name);
                model.addAttribute("designation", designation);
                model.addAttribute("about", about);
                model.addAttribute("image", image);

                model.addAttribute("cssLinkPrefix", "../../");
                return "account/student/index";
            }
            else {
                model.addAttribute("cssLinkPrefix", "../../");
                return "index";
            }
        }
        else if (userType.equalsIgnoreCase("teacher")) {
            if (username.equalsIgnoreCase(sessionUsername)) {

                TeacherData teacherData = accountService.teacherData(username);
                name = teacherData.getName();
                dob = teacherData.getDob();
                bloodGroup = teacherData.getBloodGroup();
                byte [] imageByte = teacherData.getImage();
                if (imageByte != null) image = Base64.getEncoder().encodeToString(imageByte);
                email = teacherData.getEmail();
                phone = teacherData.getPhone();
                faculty = teacherData.getFaculty();
                dept = teacherData.getDept();
                designation = teacherData.getDesignation();
                doj = teacherData.getDoj();
                about = teacherData.getAbout();
                homeAddress = teacherData.getHomeAddress();
                currentAddress = teacherData.getCurrentAddress();
                result = teacherData.getResult();

                model.addAttribute("name", name);
                model.addAttribute("designation", designation);
                model.addAttribute("about", about);
                model.addAttribute("image", image);

                model.addAttribute("cssLinkPrefix", "../../");
                return "account/teacher/index";
            }
            else {
                model.addAttribute("cssLinkPrefix", "../../");
                return "index";
            }
        }
        else {
            model.addAttribute("cssLinkPrefix", "../../");
            return "login";
        }
    }

    /*
     * Account Mapping
     */

    @RequestMapping(value="/{userType}/account/{username}/home")
    public String Profile(Model model, HttpSession session, @PathVariable String username, @PathVariable String userType) {
        SessionController.KeepSession(session);

        model.addAttribute("name", name);
        model.addAttribute("image", image);
        model.addAttribute("designation", designation);
        model.addAttribute("about", about);

        model.addAttribute("cssLinkPrefix", "../../../");
        return "account/"+userType+"/index";
    }

    @RequestMapping(value="/{userType}/account/{username}/about")
    public String About(Model model, HttpSession session, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);

        model.addAttribute("name", name);
        model.addAttribute("image", image);
        model.addAttribute("designation", designation);
        model.addAttribute("degree", degree);
        model.addAttribute("dept", dept);
        model.addAttribute("batch", batch);
        model.addAttribute("sess", sess);
        model.addAttribute("sid", sid);
        model.addAttribute("doj", doj);
        model.addAttribute("dob", dob);
        model.addAttribute("bloodGroup", bloodGroup);

        model.addAttribute("cssLinkPrefix", "../../../");
        return "account/"+userType+"/about";
    }

    @RequestMapping(value="/{userType}/account/{username}/courses")
    public String Courses(Model model, HttpSession session, HttpServletRequest request, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);

        String sessionUsername = (String) session.getAttribute("loginUsername");
        if (userType.equalsIgnoreCase("student")) {
            if (username.equalsIgnoreCase(sessionUsername)) {
                model.addAttribute("name", name);
                model.addAttribute("image", image);
                model.addAttribute("dept", dept);

                if (request.getMethod().equalsIgnoreCase("POST")) {
                    String button = request.getParameter("button");

                    if (button.equalsIgnoreCase("add")) {
                        String sess = request.getParameter("session");
                        String semester = request.getParameter("semester");
                        String courseCode = request.getParameter("course");

                        String result = accountService.insertStudentCourse(username, sess, semester, courseCode);

                        if (result.equalsIgnoreCase("success")) {
                            model.addAttribute("addCourseStatus", AccountView.StudentAddCourseStatus("Successfully Taken", "mediumseagreen"));
                        }
                        else if (result.equalsIgnoreCase("duplicateData")) {
                            model.addAttribute("addCourseStatus", AccountView.StudentAddCourseStatus("You Already Take This", "red"));
                        }
                        else {
                            model.addAttribute("addCourseStatus","");
                        }
                    }

                    if (button.equalsIgnoreCase("search")) {
                        String searchType = request.getParameter("searchType");
                        String searchKey = request.getParameter("searchKey");

                        if (searchType.equalsIgnoreCase("semester")) {
                            ArrayList<CourseData> res = accountService.studentCourseSearchBySemester(username, searchKey);

                            String courses = "";

                            for (int i=0; i<res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += AccountView.StudentCourseList(sess, courseCode, ct);
                            }

                            model.addAttribute("studentCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "account/"+userType+"/courses";
                        }
                        if (searchType.equalsIgnoreCase("courseCode")) {
                            ArrayList<CourseData> res = accountService.studentCourseSearchByCode(username, searchKey);

                            String courses = "";

                            for (int i=0; i<res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += AccountView.StudentCourseList(sess, courseCode, ct);
                            }

                            model.addAttribute("studentCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "account/"+userType+"/courses";
                        }
                    }
                }

                ArrayList<CourseData> res = accountService.studentCourseList(username);

                String courses = "";

                for (int i=0; i<res.size(); i++) {
                    String sess = res.get(i).getSession();
                    String sem = res.get(i).getSemester();
                    String courseCode = res.get(i).getCourseCode();
                    String ct = CourseTittle(courseCode);
                    courses += AccountView.StudentCourseList(sess, courseCode, ct);
                }

                model.addAttribute("studentCourseList", courses);

                model.addAttribute("cssLinkPrefix", "../../../");
                return "account/"+userType+"/courses";
            }
            else {
                model.addAttribute("cssLinkPrefix", "../../../");
                return "index";
            }
        }
        else if (userType.equalsIgnoreCase("teacher")) {
            if (username.equalsIgnoreCase(sessionUsername)) {
                model.addAttribute("name", name);
                model.addAttribute("image", image);
                model.addAttribute("dept", dept);

                if (request.getMethod().equalsIgnoreCase("POST")) {
                    String button = request.getParameter("button");

                    if (button.equalsIgnoreCase("add")) {
                        String dept = request.getParameter("department");
                        String sess = request.getParameter("session");
                        String semester = request.getParameter("semester");
                        String courseCode = request.getParameter("courseCode");

                        String result = accountService.insertTeacherCourse(username, dept, sess, semester, courseCode);

                        if (result.equalsIgnoreCase("success")) {
                            model.addAttribute("addCourseStatus", AccountView.TeacherAddCourseStatus("Successfully Taken", "mediumseagreen"));
                        }
                        else if (result.equalsIgnoreCase("duplicateYou")) {
                            model.addAttribute("addCourseStatus", AccountView.TeacherAddCourseStatus("You Already Take This", "red"));
                        }
                        else if (result.equalsIgnoreCase("duplicateAnother")) {
                            model.addAttribute("addCourseStatus", AccountView.TeacherAddCourseStatus("Already Taken By Another Teacher", "red"));
                        }
                        else {
                            model.addAttribute("addCourseStatus","");
                        }
                    }
                    if (button.equalsIgnoreCase("search")) {
                        String searchType = request.getParameter("searchType");
                        String searchKey = request.getParameter("searchKey");

                        if (searchType.equalsIgnoreCase("department")) {
                            ArrayList<CourseData> res = accountService.teacherCourseSearchByDept(username, searchKey);

                            String courses = "";

                            for (int i=0; i<res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += AccountView.TeacherCourseList(sess, courseCode, ct);
                            }

                            model.addAttribute("teacherCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "account/"+userType+"/courses";
                        }
                        if (searchType.equalsIgnoreCase("courseCode")) {
                            ArrayList<CourseData> res = accountService.teacherCourseSearchByCode(username, searchKey);

                            String courses = "";

                            for (int i=0; i<res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += AccountView.TeacherCourseList(sess, courseCode, ct);
                            }

                            model.addAttribute("teacherCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "account/"+userType+"/courses";
                        }
                    }

                    if (button.equalsIgnoreCase("viewCourse")) {
                        String sess = request.getParameter("session");
                        String courseCode = request.getParameter("courseCode");
                        studentInfoSession = sess;
                        studentInfoCourseCode = courseCode;

                        ArrayList<StudentInfo> res = accountService.courseStudentList(sess, courseCode);
                        studentInfoArrayList = res;

                        examStatus = accountService.studentExamStatus(sess, courseCode);

                        ArrayList<ClassData> cRes = accountService.teacherClassList(username, studentInfoSession, studentInfoCourseCode);
                        int len = cRes.size();
                        teacherTotalClass = len+1;
                        String teacherClass = "";

                        for (int i=0; i<len; i++) {
                            int sequence = cRes.get(i).getSequence();
                            String cSess = cRes.get(i).getSession();
                            String cCode = cRes.get(i).getCourseCode();
                            String cDate = cRes.get(i).getDate();
                            teacherClass += AccountView.TeacherClassList(i+1, cDate);
                        }

                        model.addAttribute("teacherClassList", teacherClass);

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-view";
                    }

                    if (button.equalsIgnoreCase("deleteCourse")) {

                    }

                    if (button.equalsIgnoreCase("ct1")) {
                        examStatus = accountService.studentExamStatus(studentInfoSession, studentInfoCourseCode);
                        String ctStudent = "";

                        if (examStatus.getCt1s() == 1) {
                            model.addAttribute("buttonDisableScript", AccountView.ButtonDisableString("saveMarks"));
                            ArrayList<StudentMarks> studentMarks = accountService.studentExamMarksList("ct1", studentInfoSession, studentInfoCourseCode);
                            for (int i = 0; i < studentMarks.size(); i++) {
                                String uname = studentMarks.get(i).getUsername();
                                String ssid = studentMarks.get(i).getSid();
                                String sname = studentMarks.get(i).getName();
                                int smarks = studentMarks.get(i).getMarks();
                                ctStudent += AccountView.StudentExamMarksList(i + 1, uname, ssid, sname, smarks);
                            }
                        }
                        else {
                            for (int i = 0; i < studentInfoArrayList.size(); i++) {
                                String uname = studentInfoArrayList.get(i).getUsername();
                                String ssid = studentInfoArrayList.get(i).getSid();
                                String sname = studentInfoArrayList.get(i).getName();
                                ctStudent += AccountView.StudentMarksList(i + 1, uname, ssid, sname);
                            }
                        }

                        model.addAttribute("studentMarksList", ctStudent);
                        model.addAttribute("saveMarksType", AccountView.SaveMarksType("ct1"));

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-create-exam";
                    }

                    if (button.equalsIgnoreCase("ct2")) {
                        examStatus = accountService.studentExamStatus(studentInfoSession, studentInfoCourseCode);
                        String ctStudent = "";

                        if (examStatus.getCt2s() == 1) {
                            model.addAttribute("buttonDisableScript", AccountView.ButtonDisableString("saveMarks"));
                            ArrayList<StudentMarks> studentMarks = accountService.studentExamMarksList("ct2", studentInfoSession, studentInfoCourseCode);
                            for (int i = 0; i < studentMarks.size(); i++) {
                                String uname = studentMarks.get(i).getUsername();
                                String ssid = studentMarks.get(i).getSid();
                                String sname = studentMarks.get(i).getName();
                                int smarks = studentMarks.get(i).getMarks();
                                ctStudent += AccountView.StudentExamMarksList(i + 1, uname, ssid, sname, smarks);
                            }
                        }
                        else {
                            for (int i = 0; i < studentInfoArrayList.size(); i++) {
                                String uname = studentInfoArrayList.get(i).getUsername();
                                String ssid = studentInfoArrayList.get(i).getSid();
                                String sname = studentInfoArrayList.get(i).getName();
                                ctStudent += AccountView.StudentMarksList(i + 1, uname, ssid, sname);
                            }
                        }

                        model.addAttribute("studentMarksList", ctStudent);
                        model.addAttribute("saveMarksType", AccountView.SaveMarksType("ct2"));

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-create-exam";
                    }

                    if (button.equalsIgnoreCase("ct3")) {
                        examStatus = accountService.studentExamStatus(studentInfoSession, studentInfoCourseCode);
                        String ctStudent = "";

                        if (examStatus.getCt3s() == 1) {
                            model.addAttribute("buttonDisableScript", AccountView.ButtonDisableString("saveMarks"));
                            ArrayList<StudentMarks> studentMarks = accountService.studentExamMarksList("ct3", studentInfoSession, studentInfoCourseCode);
                            for (int i = 0; i < studentMarks.size(); i++) {
                                String uname = studentMarks.get(i).getUsername();
                                String ssid = studentMarks.get(i).getSid();
                                String sname = studentMarks.get(i).getName();
                                int smarks = studentMarks.get(i).getMarks();
                                ctStudent += AccountView.StudentExamMarksList(i + 1, uname, ssid, sname, smarks);
                            }
                        }
                        else {
                            for (int i = 0; i < studentInfoArrayList.size(); i++) {
                                String uname = studentInfoArrayList.get(i).getUsername();
                                String ssid = studentInfoArrayList.get(i).getSid();
                                String sname = studentInfoArrayList.get(i).getName();
                                ctStudent += AccountView.StudentMarksList(i + 1, uname, ssid, sname);
                            }
                        }

                        model.addAttribute("studentMarksList", ctStudent);
                        model.addAttribute("saveMarksType", AccountView.SaveMarksType("ct3"));

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-create-exam";
                    }

                    if (button.equalsIgnoreCase("ct4")) {
                        examStatus = accountService.studentExamStatus(studentInfoSession, studentInfoCourseCode);
                        String ctStudent = "";

                        if (examStatus.getCt4s() == 1) {
                            model.addAttribute("buttonDisableScript", AccountView.ButtonDisableString("saveMarks"));
                            ArrayList<StudentMarks> studentMarks = accountService.studentExamMarksList("ct4", studentInfoSession, studentInfoCourseCode);
                            for (int i = 0; i < studentMarks.size(); i++) {
                                String uname = studentMarks.get(i).getUsername();
                                String ssid = studentMarks.get(i).getSid();
                                String sname = studentMarks.get(i).getName();
                                int smarks = studentMarks.get(i).getMarks();
                                ctStudent += AccountView.StudentExamMarksList(i + 1, uname, ssid, sname, smarks);
                            }
                        }
                        else {
                            for (int i = 0; i < studentInfoArrayList.size(); i++) {
                                String uname = studentInfoArrayList.get(i).getUsername();
                                String ssid = studentInfoArrayList.get(i).getSid();
                                String sname = studentInfoArrayList.get(i).getName();
                                ctStudent += AccountView.StudentMarksList(i + 1, uname, ssid, sname);
                            }
                        }

                        model.addAttribute("studentMarksList", ctStudent);
                        model.addAttribute("saveMarksType", AccountView.SaveMarksType("ct4"));

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-create-exam";
                    }

                    if (button.equalsIgnoreCase("semesterFinal")) {
                        examStatus = accountService.studentExamStatus(studentInfoSession, studentInfoCourseCode);
                        String ctStudent = "";

                        if (examStatus.getSemesterS() == 1) {
                            model.addAttribute("buttonDisableScript", AccountView.ButtonDisableString("saveMarks"));
                            ArrayList<StudentMarks> studentMarks = accountService.studentExamMarksList("semesterFinal", studentInfoSession, studentInfoCourseCode);
                            for (int i = 0; i < studentMarks.size(); i++) {
                                String uname = studentMarks.get(i).getUsername();
                                String ssid = studentMarks.get(i).getSid();
                                String sname = studentMarks.get(i).getName();
                                int smarks = studentMarks.get(i).getMarks();
                                ctStudent += AccountView.StudentExamMarksList(i + 1, uname, ssid, sname, smarks);
                            }
                        }
                        else {
                            for (int i = 0; i < studentInfoArrayList.size(); i++) {
                                String uname = studentInfoArrayList.get(i).getUsername();
                                String ssid = studentInfoArrayList.get(i).getSid();
                                String sname = studentInfoArrayList.get(i).getName();
                                ctStudent += AccountView.StudentSemesterMarksList(i + 1, uname, ssid, sname);
                            }
                        }

                        model.addAttribute("studentMarksList", ctStudent);
                        model.addAttribute("saveMarksType", AccountView.SaveMarksType("semesterFinal"));

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-create-exam";
                    }

                    if (button.equalsIgnoreCase("newClass")) {
                        String courseStudent = "";

                        for (int i=0; i<studentInfoArrayList.size(); i++) {
                            String uname = studentInfoArrayList.get(i).getUsername();
                            String ssid = studentInfoArrayList.get(i).getSid();
                            String sname = studentInfoArrayList.get(i).getName();
                            courseStudent += AccountView.CourseStudentList(i+1, uname, ssid, sname);
                        }

                        model.addAttribute("courseStudentList", courseStudent);

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-create-class";
                    }

                    if (button.equalsIgnoreCase("saveData")) {

                        for (int i=0; i<studentInfoArrayList.size();i++) {
                            String saveRes = accountService.insertStudentAttendance(teacherTotalClass, studentInfoArrayList.get(i).getUsername(), studentInfoSession, studentInfoCourseCode);
                        }

                        String [] attendances = request.getParameterValues("attendances");
                        if (attendances != null)
                            for (int i=0; i<attendances.length; i++) {
                                String updateRes = accountService.updateStudentAttendance(teacherTotalClass, attendances[i], studentInfoSession, studentInfoCourseCode);
                            }

                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                        String classDate = simpleDateFormat.format(date);

                        String result = accountService.insertTeacherClass(username, studentInfoSession, studentInfoCourseCode, classDate);

                        ArrayList<ClassData> res = accountService.teacherClassList(username, studentInfoSession, studentInfoCourseCode);

                        int len = res.size();
                        teacherTotalClass = len+1;

                        String teacherClass = "";

                        for (int i=0; i<len; i++) {
                            int sequence = res.get(i).getSequence();
                            String sess = res.get(i).getSession();
                            String cCode = res.get(i).getCourseCode();
                            String cDate = res.get(i).getDate();
                            teacherClass += AccountView.TeacherClassList(i+1, cDate);
                        }
                        // attend total/partial
                        model.addAttribute("teacherClassList", teacherClass);

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-view";
                    }

                    if (button.equalsIgnoreCase("cancelData") || button.equalsIgnoreCase("cancelMarks")) {
                        ArrayList<ClassData> res = accountService.teacherClassList(username, studentInfoSession, studentInfoCourseCode);

                        int len = res.size();
                        teacherTotalClass = len+1;

                        String teacherClass = "";

                        for (int i=0; i<len; i++) {
                            int sequence = res.get(i).getSequence();
                            String sess = res.get(i).getSession();
                            String cCode = res.get(i).getCourseCode();
                            String cDate = res.get(i).getDate();
                            teacherClass += AccountView.TeacherClassList(i+1, cDate);
                        }
                        // attend total/partial
                        model.addAttribute("teacherClassList", teacherClass);

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-view";
                    }

                    if (button.equalsIgnoreCase("saveMarks")) {
                        String saveMarksType = request.getParameter("saveMarksType");

                        for (int i=0; i<studentInfoArrayList.size();i++) {
                            String saveRes = accountService.insertStudentMarks(saveMarksType, studentInfoArrayList.get(i).getUsername(), studentInfoSession, studentInfoCourseCode);
                        }

                        String[] marks = request.getParameterValues("marks");
                        String[] users = request.getParameterValues("users");
                        if (marks != null)
                            for (int i=0; i<marks.length; i++) {
                                if (marks[i].equals("")) marks[i] = "0";
                                String updateRes = accountService.updateStudentMarks(saveMarksType, users[i], studentInfoSession, studentInfoCourseCode, Integer.parseInt(marks[i]));
                            }

                        ArrayList<ClassData> res = accountService.teacherClassList(username, studentInfoSession, studentInfoCourseCode);

                        int len = res.size();
                        teacherTotalClass = len+1;

                        String teacherClass = "";

                        for (int i=0; i<len; i++) {
                            int sequence = res.get(i).getSequence();
                            String sess = res.get(i).getSession();
                            String cCode = res.get(i).getCourseCode();
                            String cDate = res.get(i).getDate();
                            teacherClass += AccountView.TeacherClassList(i+1, cDate);
                        }

                        model.addAttribute("teacherClassList", teacherClass);

                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "account/"+userType+"/courses-view";
                    }
                }

                ArrayList<CourseData> res = accountService.teacherCourseList(username);

                String courses = "";

                for (int i=0; i<res.size(); i++) {
                    String sess = res.get(i).getSession();
                    String sem = res.get(i).getSemester();
                    String courseCode = res.get(i).getCourseCode();
                    String ct = CourseTittle(courseCode);
                    courses += AccountView.TeacherCourseList(sess, courseCode, ct);
                }

                model.addAttribute("teacherCourseList", courses);

                model.addAttribute("cssLinkPrefix", "../../../");
                return "account/"+userType+"/courses";
            }
            else {
                model.addAttribute("cssLinkPrefix", "../../../");
                return "index";
            }
        }
        else {
            model.addAttribute("cssLinkPrefix", "../../../");
            return "login";
        }
    }

    @RequestMapping(value="/{userType}/account/{username}/performance")
    public String Performance(Model model, HttpSession session, HttpServletRequest request, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);

        model.addAttribute("name", name);
        model.addAttribute("image", image);
        model.addAttribute("dept", dept);

        if (request.getMethod().equals("POST")) {
            String button = request.getParameter("button");

            if (button.equalsIgnoreCase("viewPerformance")) {

                String sess = request.getParameter("session");
                String courseCode = request.getParameter("courseCode");

                ExamStatus examStatus = accountService.studentExamStatus(sess, courseCode);
                int ct1S = examStatus.getCt1s();
                int ct2S = examStatus.getCt2s();
                int ct3S = examStatus.getCt3s();
                int ct4S = examStatus.getCt4s();
                int semesterS = examStatus.getSemesterS();
                int attendanceM = accountService.studentAttendanceMarks(username, sess, courseCode);
                int ct1M = accountService.studentCT1Marks(username, sess, courseCode);
                int ct2M = accountService.studentCT2Marks(username, sess, courseCode);
                int ct3M = accountService.studentCT3Marks(username, sess, courseCode);
                int ct4M = accountService.studentCT4Marks(username, sess, courseCode);
                int semesterM = accountService.studentSemesterMarks(username, sess, courseCode);

                int ctCnt = 0;
                int ctMarks = 0;
                if (ct1S == 1) {
                    ctCnt++;
                    ctMarks += ct1M;
                }
                if (ct2S == 1) {
                    ctCnt++;
                    ctMarks += ct2M;
                }
                if (ct3S == 1) {
                    ctCnt++;
                    ctMarks += ct3M;
                }
                if (ct4S == 1) {
                    ctCnt++;
                    ctMarks += ct4M;
                }

                int ctPerf = 0;
                int semesterPerf = 0;
                int attendancePerf = 0;

                if (attendanceM != -1) attendancePerf = attendanceM;
                if (ctCnt > 0) ctPerf = (int) Math.round(((float) ctMarks/((float) ctCnt*20))*100);
                if (semesterS == 1) semesterPerf = semesterM;
                int avgPerf = Math.round((((float) attendancePerf/100)*10) + (((float) ctPerf/100)*20) + (((float) semesterPerf/100)*70));
/*
                System.out.println(ct1S);
                System.out.println(ct2S);
                System.out.println(ct3S);
                System.out.println(ct4S);
                System.out.println(semesterS);
                System.out.println(attendanceM);
                System.out.println(ct1M);
                System.out.println(ct2M);
                System.out.println(ct3M);
                System.out.println(ct4M);
                System.out.println(semesterM);

 */

                model.addAttribute("name", name);
                model.addAttribute("courseTitle", CourseTittle(courseCode));
                model.addAttribute("studentPerformance", AccountView.StudentPerformance(attendancePerf, ctPerf, semesterPerf, avgPerf));

                model.addAttribute("cssLinkPrefix", "../../../");
                return "account/"+userType+"/performance-view";
            }

            if (button.equalsIgnoreCase("search")) {
                String searchType = request.getParameter("searchType");
                String searchKey = request.getParameter("searchKey");

                if (searchType.equalsIgnoreCase("semester")) {
                    ArrayList<CourseData> res = accountService.studentCourseSearchBySemester(username, searchKey);

                    String courses = "";

                    for (int i=0; i<res.size(); i++) {
                        String sess = res.get(i).getSession();
                        String sem = res.get(i).getSemester();
                        String courseCode = res.get(i).getCourseCode();
                        String ct = CourseTittle(courseCode);
                        courses += AccountView.StudentCourseListPerf(sess, courseCode, ct);
                    }

                    model.addAttribute("studentCourseListPerf", courses);
                    model.addAttribute("cssLinkPrefix", "../../../");
                    return "account/"+userType+"/performance";
                }

                if (searchType.equalsIgnoreCase("courseCode")) {
                    ArrayList<CourseData> res = accountService.studentCourseSearchByCode(username, searchKey);

                    String courses = "";

                    for (int i=0; i<res.size(); i++) {
                        String sess = res.get(i).getSession();
                        String sem = res.get(i).getSemester();
                        String courseCode = res.get(i).getCourseCode();
                        String ct = CourseTittle(courseCode);
                        courses += AccountView.StudentCourseListPerf(sess, courseCode, ct);
                    }

                    model.addAttribute("studentCourseListPerf", courses);
                    model.addAttribute("cssLinkPrefix", "../../../");
                    return "account/"+userType+"/performance";
                }
            }
        }

        ArrayList<CourseData> res = accountService.studentCourseList(username);
        String courses = "";

        for (int i=0; i<res.size(); i++) {
            String sess = res.get(i).getSession();
            String sem = res.get(i).getSemester();
            String courseCode = res.get(i).getCourseCode();
            String ct = CourseTittle(courseCode);
            courses += AccountView.StudentCourseListPerf(sess, courseCode, ct);
        }

        model.addAttribute("studentCourseListPerf", courses);

        model.addAttribute("cssLinkPrefix", "../../../");
        return "account/"+userType+"/performance";
    }

    @RequestMapping(value="/{userType}/account/{username}/contact")
    public String ProfileContact(Model model, HttpSession session, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);

        model.addAttribute("name", name);
        model.addAttribute("image", image);

        model.addAttribute("homeAddress", homeAddress);
        model.addAttribute("currentAddress", currentAddress);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);

        model.addAttribute("cssLinkPrefix", "../../../");
        return "account/"+userType+"/contact";
    }
}

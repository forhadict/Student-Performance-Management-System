package com.project.ict.controller;

import com.project.ict.pojo.CourseData;
import com.project.ict.pojo.ExamStatus;
import com.project.ict.pojo.StudentData;
import com.project.ict.pojo.TeacherData;
import com.project.ict.services.ProfileService;
import com.project.ict.view.AccountView;
import com.project.ict.view.ProfileView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Base64;

import static com.project.ict.controller.AccountController.CourseTittle;

@Controller
public class ProfileController {
    @Autowired
    private ProfileService profileService;

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
    private static String profileType;
    private static String profileUsername;


    @RequestMapping(value="/{userType}/profile/{username}")
    public String ProfileHome(Model model, HttpSession session, @PathVariable String username, @PathVariable String userType) {
        SessionController.KeepSession(session);

        profileType = userType;
        profileUsername = username;
        model.addAttribute("profileType", profileType);
        model.addAttribute("profileUsername", profileUsername);

        if (userType.equalsIgnoreCase("student")) {
            StudentData studentData = profileService.studentData(username);
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
            return "profile/student/index";
        }


    else if (userType.equalsIgnoreCase("teacher")) {

            TeacherData teacherData = profileService.teacherData(username);
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
            return "profile/teacher/index";
        }


        model.addAttribute("cssLinkPrefix", "");
        return "search-list";
    }

    @RequestMapping(value="/{userType}/profile/{username}/home")
    public String Profile(Model model, HttpSession session, @PathVariable String username, @PathVariable String userType) {
        SessionController.KeepSession(session);

        model.addAttribute("profileType", profileType);
        model.addAttribute("profileUsername", profileUsername);

        model.addAttribute("name", name);
        model.addAttribute("image", image);
        model.addAttribute("designation", designation);
        model.addAttribute("about", about);

        model.addAttribute("cssLinkPrefix", "../../../");
        return "profile/"+userType+"/index";
    }

    @RequestMapping(value="/{userType}/profile/{username}/about")
    public String About(Model model, HttpSession session, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);

        model.addAttribute("profileType", profileType);
        model.addAttribute("profileUsername", profileUsername);

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
        return "profile/"+userType+"/about";
    }

    @RequestMapping(value="/{userType}/profile/{username}/courses")
    public String Courses(Model model, HttpServletRequest request, HttpSession session, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);
        model.addAttribute("profileType", profileType);
        model.addAttribute("profileUsername", profileUsername);
        model.addAttribute("name", name);
        model.addAttribute("image", image);

        String sessionUserType = (String) session.getAttribute("loginType");
        if (sessionUserType != null) {
            if (userType.equalsIgnoreCase("student")) {
                if (request.getMethod().equalsIgnoreCase("POST")) {
                    String button = request.getParameter("button");
                    if (button.equals("search")) {
                        String searchType = request.getParameter("searchType");
                        String searchKey = request.getParameter("searchKey");
                        if (searchType.equalsIgnoreCase("semester")) {
                            ArrayList<CourseData> res = profileService.studentCourseSearchBySemester(username, searchKey);

                            String courses = "";

                            for (int i = 0; i < res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += ProfileView.StudentCourseList(i+1, sess, courseCode, ct);
                            }

                            model.addAttribute("studentCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "profile/" + userType + "/courses";
                        }
                        if (searchType.equalsIgnoreCase("courseCode")) {
                            ArrayList<CourseData> res = profileService.studentCourseSearchByCode(username, searchKey);

                            String courses = "";

                            for (int i = 0; i < res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += ProfileView.StudentCourseList(i+1, sess, courseCode, ct);
                            }

                            model.addAttribute("studentCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "profile/" + userType + "/courses";
                        }
                    }
                }

                ArrayList<CourseData> res = profileService.studentCourseList(username);

                String courses = "";

                for (int i=0; i<res.size(); i++) {
                    String sess = res.get(i).getSession();
                    String sem = res.get(i).getSemester();
                    String courseCode = res.get(i).getCourseCode();
                    String ct = CourseTittle(courseCode);
                    courses += ProfileView.StudentCourseList(i+1, sess, courseCode, ct);
                }

                model.addAttribute("studentCourseList", courses);
            }

            if (userType.equalsIgnoreCase("teacher")) {
                if (request.getMethod().equalsIgnoreCase("POST")) {
                    String button = request.getParameter("button");
                    if (button.equals("search")) {
                        String searchType = request.getParameter("searchType");
                        String searchKey = request.getParameter("searchKey");
                        if (searchType.equalsIgnoreCase("department")) {
                            ArrayList<CourseData> res = profileService.teacherCourseSearchByDept(username, searchKey);

                            String courses = "";

                            for (int i=0; i<res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += ProfileView.TeacherCourseList(i+1, sess, courseCode, ct);
                            }

                            model.addAttribute("teacherCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "profile/"+userType+"/courses";
                        }
                        if (searchType.equalsIgnoreCase("courseCode")) {
                            ArrayList<CourseData> res = profileService.teacherCourseSearchByCode(username, searchKey);

                            String courses = "";

                            for (int i=0; i<res.size(); i++) {
                                String sess = res.get(i).getSession();
                                String sem = res.get(i).getSemester();
                                String courseCode = res.get(i).getCourseCode();
                                String ct = CourseTittle(courseCode);
                                courses += ProfileView.TeacherCourseList(i+1, sess, courseCode, ct);
                            }

                            model.addAttribute("teacherCourseList", courses);
                            model.addAttribute("cssLinkPrefix", "../../../");
                            return "profile/"+userType+"/courses";
                        }
                    }
                }

                ArrayList<CourseData> res = profileService.teacherCourseList(username);

                String courses = "";

                for (int i=0; i<res.size(); i++) {
                    String sess = res.get(i).getSession();
                    String sem = res.get(i).getSemester();
                    String courseCode = res.get(i).getCourseCode();
                    String ct = CourseTittle(courseCode);
                    courses += ProfileView.TeacherCourseList(i+1, sess, courseCode, ct);
                }

                model.addAttribute("teacherCourseList", courses);
            }
        }
        else {
            model.addAttribute("studentCourseList", "<h1>To See Courses You Need To Login...</h1>");
            model.addAttribute("cssLinkPrefix", "../../../");
            return "profile/"+userType+"/courses-not-show";
        }

        model.addAttribute("cssLinkPrefix", "../../../");
        return "profile/"+userType+"/courses";
    }

    @RequestMapping(value="/{userType}/profile/{username}/performance")
    public String Performance(Model model, HttpServletRequest request, HttpSession session, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);
        model.addAttribute("profileType", profileType);
        model.addAttribute("profileUsername", profileUsername);
        model.addAttribute("name", name);
        model.addAttribute("image", image);
        model.addAttribute("dept", dept);

        String sessionUserType = (String) session.getAttribute("loginType");
        if (sessionUserType == "teacher") {

            if (request.getMethod().equalsIgnoreCase("POST")) {
                String button = request.getParameter("button");

                if (button.equals("viewPerformance")) {

                    String sess = request.getParameter("session");
                    String courseCode = request.getParameter("courseCode");

                    ExamStatus examStatus = profileService.studentExamStatus(sess, courseCode);
                    int ct1S = examStatus.getCt1s();
                    int ct2S = examStatus.getCt2s();
                    int ct3S = examStatus.getCt3s();
                    int ct4S = examStatus.getCt4s();
                    int semesterS = examStatus.getSemesterS();
                    int attendanceM = profileService.studentAttendanceMarks(username, sess, courseCode);
                    int ct1M = profileService.studentCT1Marks(username, sess, courseCode);
                    int ct2M = profileService.studentCT2Marks(username, sess, courseCode);
                    int ct3M = profileService.studentCT3Marks(username, sess, courseCode);
                    int ct4M = profileService.studentCT4Marks(username, sess, courseCode);
                    int semesterM = profileService.studentSemesterMarks(username, sess, courseCode);

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
                    if (ctCnt > 0) ctPerf = (int) Math.round(((float) ctMarks / ((float) ctCnt * 20)) * 100);
                    if (semesterS == 1) semesterPerf = semesterM;
                    int avgPerf = Math.round((((float) attendancePerf / 100) * 10) + (((float) ctPerf / 100) * 20) + (((float) semesterPerf / 100) * 70));

                    model.addAttribute("name", name);
                    model.addAttribute("courseTitle", CourseTittle(courseCode));
                    model.addAttribute("studentPerformance", AccountView.StudentPerformance(attendancePerf, ctPerf, semesterPerf, avgPerf));

                    model.addAttribute("cssLinkPrefix", "../../../");
                    return "profile/" + userType + "/performance-view";
                }

                if (button.equals("search")) {
                    String searchType = request.getParameter("searchType");
                    String searchKey = request.getParameter("searchKey");

                    if (searchType.equalsIgnoreCase("semester")) {
                        ArrayList<CourseData> res = profileService.studentCourseSearchBySemester(username, searchKey);

                        String courses = "";

                        for (int i = 0; i < res.size(); i++) {
                            String sess = res.get(i).getSession();
                            String sem = res.get(i).getSemester();
                            String courseCode = res.get(i).getCourseCode();
                            String ct = CourseTittle(courseCode);
                            courses += AccountView.StudentCourseListPerf(sess, courseCode, ct);
                        }

                        model.addAttribute("studentCourseListPerf", courses);
                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "profile/" + userType + "/performance";
                    }

                    if (searchType.equalsIgnoreCase("courseCode")) {
                        ArrayList<CourseData> res = profileService.studentCourseSearchByCode(username, searchKey);

                        String courses = "";

                        for (int i = 0; i < res.size(); i++) {
                            String sess = res.get(i).getSession();
                            String sem = res.get(i).getSemester();
                            String courseCode = res.get(i).getCourseCode();
                            String ct = CourseTittle(courseCode);
                            courses += AccountView.StudentCourseListPerf(sess, courseCode, ct);
                        }

                        model.addAttribute("studentCourseListPerf", courses);
                        model.addAttribute("cssLinkPrefix", "../../../");
                        return "profile/" + userType + "/performance";
                    }
                }
            }

            ArrayList<CourseData> res = profileService.studentCourseList(username);
            String courses = "";

            for (int i=0; i<res.size(); i++) {
                String sess = res.get(i).getSession();
                String sem = res.get(i).getSemester();
                String courseCode = res.get(i).getCourseCode();
                String ct = CourseTittle(courseCode);
                courses += AccountView.StudentCourseListPerf(sess, courseCode, ct);
            }

            model.addAttribute("studentCourseListPerf", courses);
        }
        else {
            model.addAttribute("studentCourseListPerf", "<h1>Only Teacher Can View Performance...</h1>");
            model.addAttribute("cssLinkPrefix", "../../../");
            return "profile/"+userType+"/performance-not-show";
        }

        model.addAttribute("cssLinkPrefix", "../../../");
        return "profile/"+userType+"/performance";
    }

    @RequestMapping(value="/{userType}/profile/{username}/contact")
    public String ProfileContact(Model model, HttpSession session, @PathVariable String userType, @PathVariable String username) {
        SessionController.KeepSession(session);

        model.addAttribute("profileType", profileType);
        model.addAttribute("profileUsername", profileUsername);

        model.addAttribute("name", name);
        model.addAttribute("image", image);

        model.addAttribute("homeAddress", homeAddress);
        model.addAttribute("currentAddress", currentAddress);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);

        model.addAttribute("cssLinkPrefix", "../../../");
        return "profile/"+userType+"/contact";
    }
}

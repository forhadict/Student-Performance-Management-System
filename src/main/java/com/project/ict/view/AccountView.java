package com.project.ict.view;

public class AccountView {
    public static String StudentAddCourseStatus(String msg, String color) {
        String value = "<span style=\"color: "+color+"\">"+msg+"</span>";
        return value;
    }

    public static String StudentCourseList (String session, String courseCode, String courseTittle) {
        String value = "<tr>\n" +
                "<form action=\"\" method=\"POST\">\n" +
                "   <td><input type=\"text\" value=\""+session+"\" disabled=\"true\"><input type=\"text\" name=\"session\" value=\""+session+"\" hidden></td>\n" +
                "   <td><input type=\"text\" value=\""+courseCode+"\" disabled=\"true\"><input type=\"text\" name=\"courseCode\" value=\""+courseCode+"\" hidden></td>\n" +
                "   <td>"+courseTittle+"</td>\n" +
                "   <td><button class=\"btn btn2 btn-primary\" name=\"button\" value=\"viewCourse\"><span class=\"icon icon-eye\"></span></button></td>\n" +
                "   <td><button class=\"btn btn1 btn-danger\" name=\"button\" value=\"deleteCourse\"><span class=\"icon icon-cross\"></span></button></td>\n" +
                "</form>\n" +
                "</tr>";

        return value;
    }

    public static String TeacherAddCourseStatus(String msg, String color) {
        String value = "<span style=\"color: "+color+"\">"+msg+"</span>";
        return value;
    }

    public static String TeacherCourseList (String session, String courseCode, String courseTittle) {
        String value = "<tr>\n" +
                "<form action=\"\" method=\"POST\">\n" +
                "   <td><input type=\"text\" value=\""+session+"\" disabled=\"true\"><input type=\"text\" name=\"session\" value=\""+session+"\" hidden></td>\n" +
                "   <td><input type=\"text\" value=\""+courseCode+"\" disabled=\"true\"><input type=\"text\" name=\"courseCode\" value=\""+courseCode+"\" hidden></td>\n" +
                "   <td>"+courseTittle+"</td>\n" +
                "   <td><button class=\"btn btn2 btn-primary\" name=\"button\" value=\"viewCourse\"><span class=\"icon icon-eye\"></span></button></td>\n" +
                "   <td><button class=\"btn btn1 btn-danger\" name=\"button\" value=\"deleteCourse\" disabled><span class=\"icon icon-cross\"></span></button></td>\n" +
                "</form>\n" +
                "</tr>";

        return value;
    }

    public static String CourseStudentList (int serial, String username, String sid, String name) {
        String value = "<tr>\n" +
                    "<td><input type=\"text\" value=\""+serial+"\" disabled=\"true\"></td>\n" +
                    "<td><input type=\"text\" value=\""+sid+"\" disabled=\"true\"></td>\n" +
                    "<td><input type=\"text\" value=\""+name+"\" disabled=\"true\"></td>\n" +
                    "<td><input type=\"checkbox\" class=\"form-check-input\" name=\"attendances\" value=\""+username+"\"></td>\n" +
                "</tr>";

        return value;
    }

    public static String TeacherClassList (int serialNo, String date) {
        String value = "<tr>\n" +
                "           <form action=\"\" method=\"POST\">\n" +
                "               <td><input type=\"text\" value=\""+serialNo+"\" disabled=\"true\"><input type=\"text\" name=\"classNo\" value=\""+serialNo+"\" hidden></td>\n" +
                "               <td><input type=\"text\" value=\""+date+"\" disabled=\"true\"><input type=\"text\" name=\"classDate\" value=\""+date+"\" hidden></td>\n" +
                "               <td><button class=\"btn btn2 btn-primary\" name=\"button\" value=\"editButton\" disabled><span class=\"icon icon-pencil\"></span></button></td>\n" +
                "               <td><button class=\"btn btn1 btn-danger\" name=\"button\" value=\"viewButton\" disabled><span class=\"icon icon-eye\"></span></button></td>\n" +
                "           </form>\n" +
                "       </tr>";

        return value;
    }

    public static String StudentMarksList (int serial, String username, String sid, String name) {
        String value = "<tr>\n" +
                "           <td><input type=\"text\" name=\"serial\" value=\""+serial+"\" disabled=\"true\"></td>\n" +
                "           <td><input type=\"text\" name=\"sid\" value=\""+sid+"\" disabled=\"true\"></td>\n" +
                "           <td><input type=\"text\" name=\"name\" value=\""+name+"\" disabled=\"true\"></td>\n" +
                "           <td><input type=\"number\" name=\"marks\" min=\"0\" max=\"20\"><input type=\"text\" name=\"users\" value=\""+username+"\" hidden></td>\n" +
                "       </tr>";
        return value;
    }

    public static String StudentExamMarksList (int serial, String username, String sid, String name, int marks) {
        String value = "<tr>\n" +
                "           <td>"+serial+"</td>\n" +
                "           <td>"+sid+"</td>\n" +
                "           <td>"+name+"</td>\n" +
                "           <td>"+marks+"</td>\n" +
                "       </tr>";
        return value;
    }

    public static String StudentSemesterMarksList (int serial, String username, String sid, String name) {
        String value = "<tr>\n" +
                "           <td><input type=\"text\" name=\"serial\" value=\""+serial+"\" disabled=\"true\"></td>\n" +
                "           <td><input type=\"text\" name=\"sid\" value=\""+sid+"\" disabled=\"true\"></td>\n" +
                "           <td><input type=\"text\" name=\"name\" value=\""+name+"\" disabled=\"true\"></td>\n" +
                "           <td><input type=\"number\" name=\"marks\" min=\"0\" max=\"70\"><input type=\"text\" name=\"users\" value=\""+username+"\" hidden></td>\n" +
                "       </tr>";
        return value;
    }

    public static String SaveMarksType (String exam) {
        String value = "<input type=\"text\" name=\"saveMarksType\" value=\""+exam+"\" hidden>";
        return value;
    }

    public static String StudentCourseListPerf (String session, String courseCode, String courseTittle) {
        String value = "<tr>\n" +
                            "<form action=\"\" method=\"POST\">\n" +
                            "   <td><input type=\"text\" value=\""+session+"\" disabled=\"true\"><input type=\"text\" name=\"session\" value=\""+session+"\" hidden></td>\n" +
                            "   <td><input type=\"text\" value=\""+courseCode+"\" disabled=\"true\"><input type=\"text\" name=\"courseCode\" value=\""+courseCode+"\" hidden></td>\n" +
                            "   <td>"+courseTittle+"</td>\n" +
                            "   <td><button class=\"btn btn2 btn-primary\" name=\"button\" value=\"viewPerformance\"><span class=\"icon icon-eye\"></span></button></td>\n" +
                            "</form>\n" +
                        "</tr>";

        return value;
    }

    public static String StudentPerformance (int attendance, int ct, int semester, int avg) {
        String value = "<div class=\"get\">\n" +
                "          <div class=\"arc\">\n" +
                "              <span class=\"text\">Attendance</span>\n" +
                "              <input type=\"hidden\" class=\"percent\" value=\""+attendance+"\" />\n" +
                "              <input type=\"hidden\" class=\"color\" value=\"#97BE0D\" />\n" +
                "          </div>\n" +
                "          <div class=\"arc\">\n" +
                "              <span class=\"text\">Class Test</span>\n" +
                "              <input type=\"hidden\" class=\"percent\" value=\""+ct+"\" />\n" +
                "              <input type=\"hidden\" class=\"color\" value=\"#D84F5F\" />\n" +
                "          </div>\n" +
                "          <div class=\"arc\">\n" +
                "              <span class=\"text\">Semester Final</span>\n" +
                "              <input type=\"hidden\" class=\"percent\" value=\""+semester+"\" />\n" +
                "              <input type=\"hidden\" class=\"color\" value=\"#88B8E6\" />\n" +
                "          </div>\n" +
                "          <div class=\"arc\">\n" +
                "              <span class=\"text\">Average</span>\n" +
                "              <input type=\"hidden\" class=\"percent\" value=\""+avg+"\" />\n" +
                "              <input type=\"hidden\" class=\"color\" value=\"#BEDBE9\" />\n" +
                "          </div>\n" +
                "      </div>";
        return value;
    }

    public static String ButtonDisableString (String button) {
        String value = "<script>\n" +
                            "var button = document.getElementById(\""+button+"\");\n" +
                            "button.disabled = \"true\";\n" +
                        "</script>";
        return value;
    }
}

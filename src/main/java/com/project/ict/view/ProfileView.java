package com.project.ict.view;

public class ProfileView {
    public static String StudentCourseList (int serial, String session, String courseCode, String courseTittle) {
        String value = "<tr>\n" +
                        "   <td>"+serial+"</td>\n" +
                        "   <td>"+session+"</td>\n" +
                        "   <td>"+courseCode+"</td>\n" +
                        "   <td>"+courseTittle+"</td>\n" +
                        "</tr>";

        return value;
    }

    public static String TeacherCourseList (int serial, String session, String courseCode, String courseTittle) {
        String value = "<tr>\n" +
                        "   <td>"+serial+"</td>\n" +
                        "   <td>"+session+"</td>\n" +
                        "   <td>"+courseCode+"</td>\n" +
                        "   <td>"+courseTittle+"</td>\n" +
                        "</tr>";

        return value;
    }
}

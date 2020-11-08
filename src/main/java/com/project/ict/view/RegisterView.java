package com.project.ict.view;

public class RegisterView {
    public static String RegisterStatus(String msg, String color) {
        String value = "<div class=\"r-container-1\">\n" +
                "            \t\t<label style=\"color: "+color+";\">"+msg+"</label>\n" +
                "            \t</div>";
        return value;
    }
}

package com.project.ict.view;

public class LoginView {
    public static String LoginStatus(String msg, String color) {
        String value = "<div class=\"status-bar\">\n" +
                "            <h3 style=\"color: "+color+";\">"+msg+"</h3>\n" +
                "       </div>";
        return value;
    }

    public static String LoginButton() {
        String value = "" +
                "   <div>" +
                "       <form th:action=\"@{/login}\" class=\"login\">\n" +
                "           <button class=\"form-control rakib-btn\">\n" +
                "               <i class=\"flaticon-user\"></i>\n" +
                "               <span>log in</span>\n" +
                "           </button>\n" +
                "       </form>" +
                "  </div>";
        return value;
    }

    public static String LogoutButton() {
        String value = "<form th:action=\"@{/logout}\" class=\"login\">\n" +
                "           <button class=\"form-control rakib-btn\">\n" +
                "               <i class=\"fa fa-arrow-left\"></i>\n" +
                "               <span>logout</span>\n" +
                "           </button>\n" +
                "       </form>";
        return value;
    }

    public static String LoginButtonUrl() {
        String value = "/login";
        return value;
    }
    public static String LoginButtonText() {
        String value = "Log In";
        return value;
    }
    public static String LoginButtonIcon() {
        String value = "<i class=\"flaticon-user\"></i>";
        return value;
    }

    public static String LogoutButtonUrl() {
        String value = "/logout";
        return value;
    }
    public static String LogoutButtonText() {
        String value = "Logout";
        return value;
    }
    public static String LogoutButtonIcon() {
        String value = "<i class=\"fa fa-arrow-left\"></i>";
        return value;
    }
}

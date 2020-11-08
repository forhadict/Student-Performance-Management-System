package com.project.ict.view;

public class SearchView {
    public static String PersonList (String userType, String username, String name, String image, String designation) {
        String value = "<div class=\"col-xl-2 col-md-3 col-sm-4 col-xs-6 col-lg-2\">\n" +
                "                <div class=\"single_team\">\n" +
                "                    <div class=\"thumb\">\n" +
                "                        <img style=\"background-image: url('data:image/jpeg;base64, "+image+"');\">\n" +
                "                        <div class=\"social_link\">\n" +
                "                           <a class=\"btn boxed-btn\" href=\""+userType+"\\profile\\"+username+"\">view</a>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"master_name text-center\">\n" +
                "                        <a class=\"trans\" href=\""+userType+"\\profile\\"+username+"\"><h3>"+name+"</h3></a>\n" +
                "                        <p>"+designation+"</p>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>";
        return value;
    }
}

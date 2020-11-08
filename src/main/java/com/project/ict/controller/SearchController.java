package com.project.ict.controller;

import com.project.ict.pojo.ProfileIntro;
import com.project.ict.services.SearchService;
import com.project.ict.view.SearchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value="/search")
    public String Home(Model model, HttpSession session, HttpServletRequest request) {
        SessionController.KeepSession(session);

        if (request.getMethod().equals("POST")) {
            String button = request.getParameter("button");

            if (button.equalsIgnoreCase("searchButton")) {

                String searchFor = request.getParameter("searchFor");
                String searchType = request.getParameter("searchType");
                String searchKey = request.getParameter("searchKey");

                model.addAttribute("searchType", searchFor);

                if (searchFor == null || searchType == null || searchKey == null) {
                    model.addAttribute("personList", "<h3>No Data Found...</h3>");
                    model.addAttribute("cssLinkPrefix", "");
                    return "search-list";
                }

                ArrayList<ProfileIntro> profileIntros = searchService.searchPerson(searchFor, searchType, searchKey.trim());

                String profile = "";
                for (int i=0; i<profileIntros.size(); i++) {
                    String username = profileIntros.get(i).getUsername();
                    String name = profileIntros.get(i).getName();
                    String image = profileIntros.get(i).getImage();
                    String designation = profileIntros.get(i).getDesignation();

                    profile += SearchView.PersonList(searchFor, username, name, image, designation);
                }

                if (profileIntros.size() == 0) {
                    model.addAttribute("personList", "<h3>No Data Found...</h3>");
                }
                else {
                    model.addAttribute("personList", profile);
                }

                model.addAttribute("cssLinkPrefix", "");
                return "search-list";
            }
        }

        model.addAttribute("cssLinkPrefix", "");
        return "search";
    }
}

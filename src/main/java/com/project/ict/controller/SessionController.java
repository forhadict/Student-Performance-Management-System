package com.project.ict.controller;

import com.project.ict.view.LoginView;

import javax.servlet.http.HttpSession;

public class SessionController {
    public static void KeepSession(HttpSession session) {
        if (session.getAttribute("loginType") == null) {
            session.setAttribute("loginLogoutUrl", LoginView.LoginButtonUrl());
            session.setAttribute("loginLogoutIcon", LoginView.LoginButtonIcon());
            session.setAttribute("loginLogoutText", LoginView.LoginButtonText());
        }
        else {
            session.setAttribute("loginLogoutUrl", LoginView.LogoutButtonUrl());
            session.setAttribute("loginLogoutIcon", LoginView.LogoutButtonIcon());
            session.setAttribute("loginLogoutText", LoginView.LogoutButtonText());
        }
    }
}

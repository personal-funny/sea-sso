package com.see.web.sso.credential;

import com.see.web.sso.modal.LoginResponse;
import com.see.web.sso.modal.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Authentication.
 *
 * Created by chris on 17-3-2.
 */
public class Authentication {

  public static void authin(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    Credential credential = SeaCredential.resolveCredential(request);
    User user = new User();
    user.setLoginName("chris");
    user.setPasswd("123456");
    // TODO
    if (user.getLoginName().equals(credential.getUsername())
        && user.getPasswd().equals(credential.getPassword())) {
      HttpSession session = request.getSession();
      session.setAttribute("user", user);
      Cookie cookie = new Cookie("JSESSIONID", session.getId());
      cookie.setMaxAge(30 * 60);
      cookie.setPath(request.getContextPath());
      response.addCookie(cookie);
      String url = response.encodeRedirectURL(request.getContextPath() + "/hello");
      response.sendRedirect(url);
    } else {
      response.setCharacterEncoding("UTF-8");
      response.setHeader("Content-type", "text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.print("Username or password error");
    }
  }

  public static void authout(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.removeAttribute("user");
    }
    String url = response.encodeRedirectURL(request.getContextPath() + "/hello");
    response.sendRedirect(url);
  }
}

package com.sea.web.sso.credential;

import com.sea.web.sso.manager.UserManager;
import com.sea.web.sso.modal.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class Authentication {

  @Autowired
  private UserManager userManager;

  public void authin(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    Credential credential = SeaCredential.resolveCredential(request);
    User user = userManager.check(credential.getUsername(), credential.getPassword());
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

  public void authout(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.removeAttribute("user");
    }
    String url = response.encodeRedirectURL(request.getContextPath() + "/hello");
    response.sendRedirect(url);
  }
}

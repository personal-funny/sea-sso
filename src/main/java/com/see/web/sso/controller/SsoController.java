package com.see.web.sso.controller;

import com.see.web.sso.credential.Authentication;
import com.see.web.sso.modal.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller impl
 *
 * Created by chris on 17-2-25.
 */
@RestController
public class SsoController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(HttpServletRequest request) {
    User user = (User) request.getSession().getAttribute("user");
    return "name : " + user.getLoginName() + " pass : " + user.getPasswd();
  }

  @RequestMapping(value="/login")
  public void login(HttpServletRequest request, HttpServletResponse response) {
    try {
      Authentication.authin(request, response);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @RequestMapping(value = "/logout")
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    try {
      Authentication.authout(request, response);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

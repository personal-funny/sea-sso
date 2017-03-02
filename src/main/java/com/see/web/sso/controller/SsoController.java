package com.see.web.sso.controller;

import com.see.web.sso.credential.Authentication;
import com.see.web.sso.credential.Credential;
import com.see.web.sso.credential.SeaCredential;
import com.see.web.sso.modal.LoginResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller impl
 *
 * Created by chris on 17-2-25.
 */
@RestController
public class SsoController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(String name) {
    return "Hello " + name;
  }

  @RequestMapping(value="/login")
  public LoginResponse hello(HttpServletRequest request) {
    Credential credential = SeaCredential.resolveCredential(request);
    return Authentication.authenticate(credential);
  }
}

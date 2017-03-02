package com.see.web.sso.credential;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * SeaCredential.
 *
 * Created by chris on 17-3-2.
 */
public class SeaCredential {

  private static final String USERNAME_PARAM_NAME = "username";
  private static final String PASSWORD_PARAM_NAME = "password";

  public static Credential resolveCredential(HttpServletRequest request) {
    Credential credential = new Credential();
    if (request != null) {
      String username = request.getParameter(USERNAME_PARAM_NAME);
      String password = request.getParameter(PASSWORD_PARAM_NAME);
      if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
        credential.setUsername(username);
        credential.setPassword(password);
      }
    }
    return credential;
  }
}

package com.see.web.sso.credential;

import com.see.web.sso.modal.LoginResponse;
import com.see.web.sso.modal.User;

/**
 * Authentication.
 *
 * Created by chris on 17-3-2.
 */
public class Authentication {

  public static LoginResponse authenticate(Credential credential) {
    LoginResponse response = new LoginResponse();
    User user = new User();
    if (user.getLoginName().equals(credential.getUsername())
        && user.getPasswd().equals(credential.getPassword())) {
      response.setResult(true);
    } else {
      response.setResult(false);
      response.setCode("fail");
      response.setMessage("Login check error");
    }
    return response;
  }
}

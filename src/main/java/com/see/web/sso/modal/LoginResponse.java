package com.see.web.sso.modal;

/**
 * LoginResponse.
 *
 * Created by chris on 17-3-2.
 */
public class LoginResponse {

  /**
   * true: success; false: fail
   */
  private boolean result;

  /**
   * response code
   */
  private String code;

  /**
   * message
   */
  private String message;

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

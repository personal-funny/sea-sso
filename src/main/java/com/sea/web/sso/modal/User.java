package com.sea.web.sso.modal;

import java.io.Serializable;

/**
 * User modal.
 *
 * Created by chris on 17-2-26.
 */
public class User implements Serializable {

  private static final long serialVersionUID = -1364351151077498947L;

  private long id;
  private String loginName;
  private String passwd;
  private int status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}

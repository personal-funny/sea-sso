package com.sea.web.sso.manager;

import com.sea.web.sso.dao.UserDAO;
import com.sea.web.sso.modal.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User manager.
 *
 * Created by chris on 17-4-9.
 */
@Service
public class UserManager {

  @Autowired
  private UserDAO userDAO;

  public void create(User user) {
    userDAO.create(user);
  }

  public void delete(User user) {
    userDAO.delete(user);
  }

  public void update(User user) {
    userDAO.update(user);
  }

  public User get(long userId) {
    return userDAO.get(userId);
  }

  public User check(String loginName, String password) {
    return userDAO.check(loginName, password);
  }
}

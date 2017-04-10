package com.sea.web.sso.dao;

import com.sea.web.sso.modal.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Service for Users' CRUD.
 *
 * Created by chris on 17-4-9.
 */
@Repository
public interface UserDAO {

  /**
   * Create a user.
   *
   * @param user target user's info.
   */
  public void create(User user);

  /**
   * Delete a user from database;
   *
   * @param user target user's info
   */
  public void delete(User user);

  /**
   * Update a user.
   *
   * @param user target user's info
   */
  public void update(User user);

  /**
   * Get a user's info by userId.
   *
   * @param userId target user's id
   * @return User object
   */
  public User get(long userId);

  /**
   * Check user info.
   *
   * @param loginName login name
   * @param passwd    password
   * @return current user
   */
  public User check(@Param("loginName") String loginName, @Param("passwd") String passwd);
}

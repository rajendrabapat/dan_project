package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {

  int register(User user);

  User validateUser(Login login);
  
  List<User> getUsersList();
}

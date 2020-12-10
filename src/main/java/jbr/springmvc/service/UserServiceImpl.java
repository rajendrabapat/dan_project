package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }
  
  
  /**
  New code added to show users . This should ultimtely take us to jsp showUsers.jsp
  * @return
  */
  
  public List<User> getUsersList(){
	  
	  List<User> ret = userDao.getUsersList() ;
	  System.out.println("############### " + ret.size() );
	  for(int i = 0; i< ret.size() ; i++ )
	  {
		  System.out.println("############### " + ((User)ret.get(i)).getFirstname() );
		  System.out.println("############### " + ((User)ret.get(i)).getLastname() );
		  System.out.println("############### " + ((User)ret.get(i)).getUsername() );
	  }
	  return ret;

/**n
 */
  }

}

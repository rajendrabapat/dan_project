package jbr.springmvc.dao;

import java.util.List;

/*import jbr.springmvc.model.Login;*/ 
import jbr.springmvc.model.Account;

public interface AccountDao {

  int record(Account account);
  
  int updateAccount(Account account);
  
  

  /*User validateUser(Login login);*/
  
  List<Account> getAccountsList();
  
  public Account getAccountByName(String accName) ;
}

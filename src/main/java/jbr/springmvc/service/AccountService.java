/* This is similar to UserServices */

package jbr.springmvc.service;

import jbr.springmvc.model.Account;
import java.util.List;

public interface AccountService {

  int record(Account account);

   List<Account> getAccountsList();
   
   public Account getAccountByName(String accName) ;
   public int updateAccount(Account account);
  
}

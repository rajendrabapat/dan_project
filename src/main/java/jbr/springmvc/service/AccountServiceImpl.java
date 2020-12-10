package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.AccountDao;

import jbr.springmvc.model.Account;
/**
Calling AccountDao 
*/
public class AccountServiceImpl implements AccountService {

  @Autowired
  public AccountDao accountDao;

  public int record(Account account) {
    return accountDao.record(account);
  }

  /**
  This code is used to print Account List on the ShowAccounts page.  
  */
  public List<Account> getAccountsList(){
	  
	  List<Account> ret1 = accountDao.getAccountsList() ;
	  System.out.println("############### " + ret1.size() );
	  for(int i = 0; i< ret1.size() ; i++ )
	  {
		  System.out.println("############### " + ((Account)ret1.get(i)).getAccount_name() );
		  System.out.println("############### " + ((Account)ret1.get(i)).getAccount_city() );
		  System.out.println("############### " + ((Account)ret1.get(i)).getAccount_state() );
	  }
	  return ret1;



 }
  
  public Account getAccountByName(String accName) {
	  return accountDao.getAccountByName(accName);  
  }
  
  public int updateAccount(Account account) {
	  return accountDao.updateAccount(account); 
  }
 
  
}

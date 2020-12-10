package jbr.springmvc.controller;
/** These are import utilities and other needed files */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Account;
import jbr.springmvc.model.User;
import jbr.springmvc.service.AccountService;

@Controller
public class AccountController {
  @Autowired
  public AccountService accountService;

  @RequestMapping(value = "/record", method = RequestMethod.GET)
  public ModelAndView showRecord(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("record");
       
    String accountNameParam = (String) request.getParameter("name") ;
    
    if(accountNameParam != null) {
        Account retAccount = accountService.getAccountByName(accountNameParam) ;
        
        mav.addObject("account", retAccount);   
    	
    }
    else {
    	mav.addObject("account", new Account());
    }
    	

    return mav;
  }

  /** This part of the code is Creating or updating the account **/ 
  
  @RequestMapping(value = "/recordProcess", method = RequestMethod.POST)
  public ModelAndView addAccount(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("account") Account account) {
	   String method = (String) request.getParameter("method");
	   System.out.println("######################## method 2" + method);
	   
	  if(method.equals("create")) 
		  accountService.record(account);
	  else
		  accountService.updateAccount(account);
	  
    return new ModelAndView("welcome", "account_name", account.getAccount_name());
  }
  
  /*
  New code added to show accounts -- Connected to Show Accounts JSP. This should ultimtely take us to jsp showUsers.jsp
  
  */ 
 @RequestMapping(value = "/showAccounts", method = RequestMethod.GET)
   public ModelAndView showAccountsPage(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("showAccounts");
     
     List<Account> accountList = accountService.getAccountsList();
     
     String tmpAccountFirstnamesLabel = "Account Name - City - State  <br>" ; 
     String tmpAccountFirstnames = "" ; 
     
     mav.addObject("accountList", accountList);


     return mav;
   }
 
 
 /* This is to get the account information and show on the record page 
  * 
  */
 @RequestMapping(value = "/getAccount", method = RequestMethod.GET)
 public ModelAndView getAccountRecord(HttpServletRequest request, HttpServletResponse response) {
   //ModelAndView mav = new ModelAndView("editSingleAccount");
   
   System.out.println("######################## in getAccountRecord " + (String) request.getParameter("name"));
   
   String accountNameParam = (String) request.getParameter("name") ;
   
   Account retAccount = accountService.getAccountByName(accountNameParam) ;
   
   System.out.println("$$$$$$$$$$$$$$$ REturned SINGLE account " + retAccount.getAccount_name() + "   ,  "  + retAccount.getAccount_city()  );
   
   //mav.addObject("singleAccount", retAccount);
   
   ModelAndView mav = new ModelAndView("record");
   mav.addObject("account", retAccount);   

   return mav;
 } 
 

 
}

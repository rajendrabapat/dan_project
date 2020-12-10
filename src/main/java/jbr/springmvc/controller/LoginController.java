package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class LoginController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }
  
 
  
  /**
 New code added to show users . This should ultimtely take us to jsp showUsers.jsp
 * @return
 */
@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
  public ModelAndView showUsersPage(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("showUsers");
    
    List<User> userList = userService.getUsersList();
    List<String> list = getList();
    String tmpUserFirstnamesLabel = "First Name - Last Name - User ID  <br>" ; 
    String tmpUserFirstnames = "" ; 
    
    mav.addObject("userList", userList);
    /*System.out.println("#############################" + userList.size());
    
    for(int i=0; i<userList.size() ; i++ ) {
    	tmpUserFirstnames = tmpUserFirstnames  + userList.get(i).getFirstname() + " " + userList.get(i).getLastname()  + "- " + userList.get(i).getUsername();
    	
    	tmpUserFirstnames = tmpUserFirstnames + "<br>"; 
    }
    tmpUserFirstnames = tmpUserFirstnamesLabel + tmpUserFirstnames ; */
    mav.addObject("firstNames", tmpUserFirstnames);


    return mav;
  } 

	@GetMapping(path = "users")
	public ResponseEntity<?> listUsers() {
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Angular invoking");
		
		List<User> userList = userService.getUsersList();
	    return ResponseEntity.ok(userList);
	}




private List<String> getList() {

    List<String> list = new ArrayList<String>();
    list.add("List A");
    list.add("List B");
    list.add("List C");
    list.add("List D");
    list.add("List 1");
    list.add("List 2");
    list.add("List 3");

    return list;

}


/**This code pertains to login Process 
*/

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;

    User user = userService.validateUser(login);
    List<String> list = getList();

    if (null != user) {
      mav = new ModelAndView("welcome");
      mav.addObject("lists", list.get(1));
      mav.addObject("firstname", user.getFirstname());
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }

    return mav;
  }

}

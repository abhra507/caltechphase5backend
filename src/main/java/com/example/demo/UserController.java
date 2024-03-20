package com.example.demo;

import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;



@Controller
@CrossOrigin(origins = "*")
public class UserController {
Logger log=Logger.getAnonymousLogger();
@Autowired
UserService service;

/*@ResponseBody
@RequestMapping("/login")
public String login(HttpServletRequest request,HttpServletResponse response,@RequestBody User user) {
	User ee=service.findbynamepsswd(user.getName(),user.getPassword());
	if(ee!=null) {
		return "Welcome , "+ee.getName()+" ,"+ee.getUserid();
			}
	else {
	   return "login failed" ;
	}

}

@ResponseBody
@RequestMapping("/register")
public String registerms(HttpServletRequest request,HttpServletResponse response,@RequestBody User user) {
	User ee=service.createuser(user);
	if(ee !=null) {
	return ("registration done succcessfully for " +ee.getName());
	}
	else
	{
		return "registration failed";
	}
	
}*/

@ResponseBody
@RequestMapping("/login")
public User loginProcess(@RequestBody User user, Model model) {
    User user1 = service.findbynamepsswd(user);
    System.out.println("the user object is "+user1.toString());
    return user1;
}

@ResponseBody
@RequestMapping("/api/register")
public User showRegister() {
    return new User();
}

@ResponseBody
@RequestMapping("/register")
public User addUser(@RequestBody User user, Model model) {
    System.out.println(user.toString());
    service.register(user);
    return user;
}

@ResponseBody
@RequestMapping("/checkUserName")
public boolean checkAvailability(@RequestBody String username, Model model){
    return service.usernameExists(username);
}

}

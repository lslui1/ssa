package ssa.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssa.entity.Login;
import ssa.entity.Review;
import ssa.service.ILoginService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class LoginController {
	
	
	@Autowired
	private ILoginService loginService;
	
	@ResponseBody
	@RequestMapping(value= "/login", method = RequestMethod.POST)
    public String loginCheck(@RequestBody Login loginData) {
			String user_name = loginData.getUser_name();
			System.out.println(loginData);
			
			String password = loginData.getPassword();
			System.out.println(user_name + " " + password);
    		Integer loginCode = 3;
			boolean loginCheck = false;
			loginCheck = loginService.doesLoginExist(user_name);
			System.out.println(loginService.doesLoginExist(user_name));
			if (loginCheck == true) {
				Login login = loginService.getLoginById(user_name);
				System.out.println(loginService.getLoginById(user_name));
					if (login.getPassword().equals(password)) {
							//Successfully logs in and passes user's ID
							loginCode = login.getId();
							System.out.println(loginCode + "working id");
					}
					else {
						//Wrong password code
						loginCode = 2;
					}
			}
			else {
				//Invalid User ID code
				loginCode = 3;
			}
	       	return loginCode.toString();
	}
	
	
	@RequestMapping(value= "/deletelogin/{id}", method = RequestMethod.GET)
    public ResponseEntity<Review> deleteLogin(@PathVariable("id") Integer id) {
        loginService.deleteLogin(id);
        return new ResponseEntity<Review>(HttpStatus.OK);
    }
	
	@RequestMapping(value= "/insertlogin", method = RequestMethod.POST)
	public ResponseEntity<Void> insertLogin(@RequestBody Login login) {
		loginService.insertLogin(login);
	    return new ResponseEntity<Void>(HttpStatus.OK);    
    }
	
	
	@RequestMapping(value= "/changepassword", method = RequestMethod.PUT)
	public ResponseEntity<Void> changePassword(@RequestBody Login login) {
		loginService.changePassword(login);
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}

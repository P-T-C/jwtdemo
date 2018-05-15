package jwtdemo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import jwtdemo.model.User;
import jwtdemo.service.TokenAuthenticationService;

@Controller
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLogin(){
		ModelAndView mav = new ModelAndView("login");		
		return mav;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> login(HttpServletRequest httpRequest,HttpServletResponse httpResponse,@RequestBody User user){			
		String token = TokenAuthenticationService.generateToken(user.getUserName());
		HashMap<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("token", token);
		return tokenMap;
	}
}

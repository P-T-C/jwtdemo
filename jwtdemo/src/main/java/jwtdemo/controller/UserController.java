package jwtdemo.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jwtdemo.dao.UserDAO;
import jwtdemo.model.User;

@RestController
public class UserController {
    @RequestMapping(value="users",method = RequestMethod.GET)
    @ResponseBody
    public List<User> users() {   
    	System.out.println("users");
        return UserDAO.getAllUser();
    }
}
	


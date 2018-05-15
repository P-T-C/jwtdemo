package jwtdemo.dao;

import java.util.ArrayList;
import java.util.List;

import jwtdemo.model.User;

public class UserDAO {
	public static List<User> getAllUser(){
		List<User> list = new ArrayList<User>();
		for(int i=0;i<5;i++) {
			User user = new User("user"+i,"password "+i);
			list.add(user);
		}
		return list;		
	}
	public static String findEmailByUserId(String userID) {
		String email = "congptph05286@fpt.edu.vn";
		return email;
	}
}

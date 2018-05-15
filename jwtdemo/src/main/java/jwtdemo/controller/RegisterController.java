package jwtdemo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jwtdemo.config.MailMail;

@RestController
public class RegisterController {
	@RequestMapping(value = "register")
	public String verifyAccount(@PathVariable("user_id") String userID ) {
		System.out.println("register");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		mm.sendMail("congpt@vnext.com.vn", "Testing123", "Testing only \n\n Hello Spring Email Sender", "ewqeqwewe");
		return "login";
	}
}

package jwtdemo.config;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailMail
{
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String to, String subject, String msg,String replyTo) {
		SimpleMailMessage message = new SimpleMailMessage();		
	
		message.setTo(to);
		message.setSubject(subject);
		message.setReplyTo(replyTo);
		message.setText(msg);
		mailSender.send(message);	
	}
}

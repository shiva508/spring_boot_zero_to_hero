package com.infinity.service.feedbackImpl;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.infinity.service.feedback.FeedbackSender;
@Component
public class FeedbackMailSender implements FeedbackSender {
	@Autowired
private JavaMailSenderImpl mailSender; 
	@Value("${spring.mail.port}")
	private String port;
	@Value("${spring.mail.host}")
	private String host;
	@Value("${spring.mail.username}")
	private String userName;
	@Value("${spring.mail.host}")
	private String password;
	@Override
	public void sendFeedback(String from, String name, String feedback) {
		  
			/*MimeMessageHelper helper=new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());*/
			mailSender.setPort(Integer.parseInt(port));
			mailSender.setHost(host);
			mailSender.setPassword(password);
			mailSender.setUsername(userName);
			System.out.println(userName);
			 SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo("feedback@noteit.com");
		        message.setSubject("New feedback from " + name);
		        message.setText(feedback);
		        message.setFrom(from);
			mailSender.send(message);
		
		
	}
}

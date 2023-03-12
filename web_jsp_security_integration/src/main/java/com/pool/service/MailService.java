package com.pool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.pool.config.EmailCfg;
import com.pool.model.Feedback;

@Component
public class MailService {
	@Autowired
	private EmailCfg emailCfg;
	public void sendFeedback(Feedback feedback) {

		// Create a mail sender
				JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
				mailSender.setHost(this.emailCfg.getHost());
				mailSender.setPort(this.emailCfg.getPort());
				mailSender.setUsername(this.emailCfg.getUsername());
				mailSender.setPassword(this.emailCfg.getPassword());

		// Create an email instance
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setFrom(feedback.getEmail());
				mailMessage.setTo("daasrishiva1@gmail.com");
				mailMessage.setSubject("New feedback from " + feedback.getName());
				mailMessage.setText(feedback.getFeedback());

		// Send mail
				mailSender.send(mailMessage);
			}
}

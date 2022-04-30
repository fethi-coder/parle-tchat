package com.parle.ParleMsg.MAIL;

import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.parle.ParleMsg.MODEL.Inscription;
import com.parle.ParleMsg.MODEL.PropertiesConfig;
import com.parle.ParleMsg.REPOSITORY.PropertiesConfiRepository;

@Component
public class Email {


	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	PropertiesConfiRepository properties;
	
	/*----------------------------------------------------- mail test -------------------------------------------*/
	public String sendRdvEmailClient(Inscription in) {
	Optional<PropertiesConfig> propss = properties.findById(1);
		
		Properties props = new Properties();
		props.put("spring.mail.host", propss.get().getHost());
		props.put("spring.mail.port", propss.get().getPort());
		props.put("spring.mail.username", propss.get().getUsername());
		props.put("spring.mail.password", propss.get().getPassword());
		props.put("spring.mail.properties.mail.smtp.auth", propss.get().getAuth());
		props.put("spring.mail.properties.mail.smtp.connectiontimeout", propss.get().getConnectiontimeout());
		props.put("spring.mail.properties.mail.smtp.timeout", propss.get().getTimeout());
		props.put("spring.mail.properties.mail.smtp.writetimeout", propss.get().getWritetimeout());
		props.put("spring.mail.properties.mail.smtp.starttls.enable", propss.get().getEnable());
		try {
			SimpleMailMessage msg = new SimpleMailMessage();

			msg.setTo(in.getMail());
			msg.setSubject("Message de confirmation PARLE.fr");
			msg.setText("");

			System.out.println(msg);

			javaMailSender.send(msg);

			return "Votre message à été envoyé avec succes";
		} catch (Exception e) {
			System.out.println("Votre envoi à echoué : " + e.getMessage());
			return "Votre envoi à echoué : " + e.getMessage();
		}

	}

}

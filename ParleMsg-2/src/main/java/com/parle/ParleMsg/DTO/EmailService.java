package com.parle.ParleMsg.DTO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.multipart.MultipartRequest;

import com.parle.ParleMsg.MODEL.Inscription;
import com.parle.ParleMsg.MODEL.PropertiesConfig;
import com.parle.ParleMsg.REPOSITORY.PropertiesConfiRepository;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Configuration config;
	
	@Autowired
	PropertiesConfiRepository properties;
	
	
/*----------------------------------------------------------- Mail client confirmation plus Id  ----------------------------------------------------*/	
	public MailResponse sendMail(MultipartRequest request, Inscription in, Map<String, Object> model) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		
	
		
		
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.addAttachment("parler.png", new ClassPathResource("parler.png"));

			freemarker.template.Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t,model);

			helper.setTo(in.getMail());
			helper.setText(html,true);
			helper.setSubject("Inscription Parle.fr");
			helper.setFrom("fehtibetthar9@gmail.com");
			sender.send(message);

			response.setMessage("Mail send to : " + in.getMail());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {

			response.setMessage("email envoyé : " + e.getMessage());
			response.setStatus(Boolean.FALSE);

		}
		return response;
	}

	/*----------------------------------------------- Mail ADMIN ---------------------------------*/

	public String sendMailAdmin(Inscription inscri) throws Exception {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			
			
			
			msg.setTo("admin@dev-fefe.fr");
			msg.setSubject("nouveau speaker : " + inscri.getName() + "mail :" + inscri.getMail());
			msg.setText("identité :" + inscri.getName() + " , username : " + inscri.getUsername() + " , mail : " + inscri.getMail());

			System.out.println(msg);
			sender.send(msg);
			return "success";
		} catch (Exception e) {
			System.out.println("Votre envoi à echoué : " + e.getMessage());
			return "Votre envoi à echoué : " + e.getMessage();
		}
	
	}

}

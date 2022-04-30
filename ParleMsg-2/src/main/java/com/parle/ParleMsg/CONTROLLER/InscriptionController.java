package com.parle.ParleMsg.CONTROLLER;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parle.ParleMsg.DTO.EmailService;
import com.parle.ParleMsg.MAIL.Email;
import com.parle.ParleMsg.MODEL.Authentication;
import com.parle.ParleMsg.MODEL.Inscription;
import com.parle.ParleMsg.MODEL.ResponseMessage;
import com.parle.ParleMsg.REPOSITORY.AuthenticationRepository;
import com.parle.ParleMsg.REPOSITORY.InscriptionRepository;

@CrossOrigin("http://localhost:4200")
@RestController
public class InscriptionController {

	@Autowired
	InscriptionRepository inscription;

	@Autowired
	AuthenticationRepository authentication;

	@Autowired
	Email mails;

	@Autowired
	EmailService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@SuppressWarnings("unused")
	@CrossOrigin("/")
	@RequestMapping("/createInscri")
	public  void saveInscription(@RequestBody Inscription inscr)  throws Exception {
		Optional<Inscription> pseudo = inscription.findByPseudo(inscr.getPseudo());
		Optional<Inscription> mail = inscription.findByMail(inscr.getMail());
		Optional<Inscription> mdp = inscription.findByMdp(inscr.getMdp());

			if(!mail.isPresent()) {
				Inscription a = new Inscription();
				a.setInscription_id(a.getInscription_id());
				a.setActive(inscr.getActive());
				a.setConfirme(inscr.getConfirme());
				a.setMail(inscr.getMail());
				a.setMdp(passwordEncoder.encode(inscr.getMdp()));
				a.setName(inscr.getName());
				a.setPseudo(inscr.getPseudo());
				a.setRoles("USER");
				a.setUsername(inscr.getUsername());
				inscription.save(a);
				
				Authentication auth = new Authentication();
				auth.setActive(true);
				auth.setImg(null);
				auth.setPassword(a.getMdp());
				auth.setPseudo(a.getPseudo());
				auth.setConfirme(a.getConfirme());
				auth.setUsername(a.getUsername());
				auth.setName(a.getName());
				auth.setPseudo(a.getPseudo());
				auth.setAuth_id(a.getInscription_id());
				auth.setRoles(a.getRoles());
			
				Map<String, Object> model = new HashMap<>();
				model.put("Name",a.getPseudo());
				model.put("Password",a.getConfirme());
				service.sendMail(null, inscr, model);
				service.sendMailAdmin(inscr);
	            authentication.save(auth);
				ResponseMessage mes = new ResponseMessage("inscription enregistré");
				
				System.out.println(mes);
	
			}else {
				System.out.println("déjà existant");
			}
			}
				
	
	}



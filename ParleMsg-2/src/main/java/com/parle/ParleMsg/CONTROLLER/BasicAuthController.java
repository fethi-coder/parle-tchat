package com.parle.ParleMsg.CONTROLLER;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parle.ParleMsg.MODEL.Authentication;
import com.parle.ParleMsg.MODEL.Connecter;
import com.parle.ParleMsg.MODEL.Image;
import com.parle.ParleMsg.MODEL.Inscription;
import com.parle.ParleMsg.REPOSITORY.AuthenticationRepository;
import com.parle.ParleMsg.REPOSITORY.ConnecterRepository;
import com.parle.ParleMsg.REPOSITORY.ImageRepository;
import com.parle.ParleMsg.REPOSITORY.InscriptionRepository;
import com.parle.ParleMsg.SECURITY.MyUserDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/connexion")
public class BasicAuthController {

	@Autowired
	InscriptionRepository inscription;

	@Autowired
	ConnecterRepository connect;

	@Autowired
	MyUserDetailsService myuser;

	@Autowired
	ImageRepository image;

	@Autowired
	AuthenticationRepository authentication;

	@GetMapping("/login")
	public Authentication login(@RequestParam String pseudo, @RequestParam String password, @RequestParam Long option) {
		Optional<Inscription> in = inscription.findByPseudo(pseudo);
		Optional<Inscription> inP = inscription.findByConfirme(password);
		Optional<Authentication> au = authentication.findByPseudo(pseudo);
		Optional<Connecter> connector = connect.findByPseudo(pseudo);
		Optional<Image> im = image.findById(option);
		UserDetails user = myuser.loadUserByUsername(in.get().getUsername());

		

				Authentication auth = new Authentication(in.get().getUsername(), in.get().getPseudo(),
						in.get().getMdp(), im.get().getUrl(), in.get().getActive(), in.get().getRoles(),
						in.get().getName(), in.get().getConfirme(), in.get().getInscription_id());
				Connecter connecter = new Connecter();
				connecter.setConnecter_id(in.get().getInscription_id());
				connecter.setPresent(true);
				connecter.setPseudo(pseudo);
				connect.save(connecter);
				return auth;
			
		
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam Long log_out) {
		Optional<Connecter> in = connect.findById(log_out);
		try {
			if (in.isPresent() && in.isEmpty()) {
				System.out.println("logout");
				return ResponseEntity.ok("déconnexion éffectuée");
			} else {
				return null;
			}

		} catch (NumberFormatException e) {
			System.out.println("format inconnu ou vide" + e);
			throw e;
		}

	}

}

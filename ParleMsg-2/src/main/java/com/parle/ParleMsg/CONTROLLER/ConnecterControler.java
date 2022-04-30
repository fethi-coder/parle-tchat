package com.parle.ParleMsg.CONTROLLER;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parle.ParleMsg.MODEL.Authentication;
import com.parle.ParleMsg.MODEL.Connecter;
import com.parle.ParleMsg.REPOSITORY.AuthenticationRepository;
import com.parle.ParleMsg.REPOSITORY.ConnecterRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/connexion")
public class ConnecterControler {

	@Autowired
	ConnecterRepository connecteur;

	@Autowired
	AuthenticationRepository authentication;

	@PostMapping("/ok")
	public ResponseEntity<?> savePseudo(@RequestBody String pseudo) {
		Optional<Connecter> in = connecteur.findByPseudo(pseudo);
		Optional<Authentication> au = authentication.findByPseudo(pseudo);

		try {

			if (!in.isPresent()) {
				Connecter f = new Connecter();
				f.setConnecter_id(au.get().getAuth_id());
				f.setPseudo(pseudo);
				f.setPresent(au.get().getActive());
				connecteur.save(f);
				return ResponseEntity.ok("connexion établi" + f);
			} else {
				System.out.println("no");
			}
		} catch (Exception e) {
			System.out.println("id vide");
			throw e;
		}
		return ResponseEntity.badRequest().body("mauvaise requête");
	}

	@DeleteMapping("/goodbye")
	public ResponseEntity<String> deletePseudo(@RequestParam Long id) throws Exception {
		Optional<Connecter> in = connecteur.findById(id);
		try {
			if (in.isPresent() && !in.isEmpty()) {
				connecteur.deleteById(id);
				return ResponseEntity.ok("found");
			}
		} catch (Exception e) {
			System.out.println("format vide ou non valide");
		}

		return ResponseEntity.ok("not found");
	}

	@RequestMapping("/allConnecter")
	public List<Connecter> findAll() {
		return connecteur.findAll();
	}

}

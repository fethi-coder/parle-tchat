package com.parle.ParleMsg.CONTROLLER;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parle.ParleMsg.MODEL.Forum;
import com.parle.ParleMsg.REPOSITORY.ForumRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	ForumRepository forumRepo;

	/*----------------------------------------   envoie tous les messsages et les les utilisateurs authentifié       ------------*/

	@RequestMapping("/allMessage")
	public List<Forum> findAll() {
		return forumRepo.findAll();
	}

	/*------------------------------------------- envoie message ---------------------------------------------*/
	@PostMapping("/envoieMessage")
	public String saveMessage(@RequestBody Forum forum) {
		
			Forum ab = new Forum();
			ab.setDate(forum.getDate());
			ab.setImage(forum.getImage());
			ab.setMsg(forum.getMsg());
			ab.setName(forum.getName());
			ab.setPseudo(forum.getPseudo());
			ab.setTime(forum.getTime());
		forumRepo.save(ab);
		return "save";
		}
	
	
}

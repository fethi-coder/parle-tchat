package com.parle.ParleMsg.REPOSITORY;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parle.ParleMsg.MODEL.Connecter;
import com.parle.ParleMsg.MODEL.Forum;


@Repository
public interface ForumRepository extends JpaRepository<Forum, Long>{

	void save(Connecter f);

	
	
}

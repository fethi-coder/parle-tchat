package com.parle.ParleMsg.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.parle.ParleMsg.MODEL.Inscription;

@Repository
@EnableJpaRepositories
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
	Optional<Inscription> findByUsername(String username);
	
	Optional<Inscription> findByMail(String mail);
	
	Optional<Inscription> findByPseudo(String pseudo);

	Optional<Inscription> findByMdp(String password);

	Optional<Inscription> findByConfirme(String password);

	
}

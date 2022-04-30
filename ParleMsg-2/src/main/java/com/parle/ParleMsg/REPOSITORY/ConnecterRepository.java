package com.parle.ParleMsg.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.parle.ParleMsg.MODEL.Connecter;

@Repository
@EnableJpaRepositories 
public interface ConnecterRepository extends JpaRepository<Connecter, Long> {

	Optional<Connecter> findByPseudo(String pseudo);



}

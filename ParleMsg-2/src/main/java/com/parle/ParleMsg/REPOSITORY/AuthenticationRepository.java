package com.parle.ParleMsg.REPOSITORY;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parle.ParleMsg.MODEL.Authentication;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

Optional<Authentication> findByPseudo(String pseudo);


}

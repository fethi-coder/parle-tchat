package com.parle.ParleMsg.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.parle.ParleMsg.MODEL.PropertiesConfig;

@Repository
@EnableJpaRepositories
public interface PropertiesConfiRepository extends JpaRepository<PropertiesConfig,Long> {

	Optional<PropertiesConfig> findById(int i);

}

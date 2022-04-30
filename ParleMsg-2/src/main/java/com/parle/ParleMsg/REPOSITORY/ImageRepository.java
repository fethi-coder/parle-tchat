package com.parle.ParleMsg.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parle.ParleMsg.MODEL.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}

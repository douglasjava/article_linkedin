package com.example.security.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.demo.model.PaperPO;

@Repository
public interface Papers extends JpaRepository<PaperPO, Long> {

	Optional<PaperPO> findByName(String name);

}

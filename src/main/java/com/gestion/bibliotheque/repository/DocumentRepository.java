package com.gestion.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gestion.bibliotheque.entity.Documents;


@Repository
public interface DocumentRepository extends JpaRepository<Documents,Long> {
	

}

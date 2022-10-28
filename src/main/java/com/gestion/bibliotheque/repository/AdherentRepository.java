package com.gestion.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.gestion.bibliotheque.entity.Adherent;


@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long>{
	public Adherent findByCin(String cin);
}

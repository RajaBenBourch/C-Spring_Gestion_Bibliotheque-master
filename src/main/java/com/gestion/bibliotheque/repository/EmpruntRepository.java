package com.gestion.bibliotheque.repository;

import java.util.List;

import org.springframework.data.domain.Page;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.gestion.bibliotheque.entity.Adherent;
import com.gestion.bibliotheque.entity.Emprunt;



@Repository("EmpruntRepository")
public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {
	public List<Emprunt> findByAdherent(Adherent adherent);


}

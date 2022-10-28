package com.gestion.bibliotheque.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.gestion.bibliotheque.entity.Dictionnaire;


@Repository("DictionnaireRepository")
public interface DictionnaireRepository extends JpaRepository<Dictionnaire, Long> {


}

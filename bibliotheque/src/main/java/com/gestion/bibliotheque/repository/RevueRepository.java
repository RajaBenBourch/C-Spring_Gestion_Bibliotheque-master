package com.gestion.bibliotheque.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.gestion.bibliotheque.entity.Revue;


@Repository("RevueRepository")
public interface RevueRepository extends JpaRepository<Revue, Long> {


}

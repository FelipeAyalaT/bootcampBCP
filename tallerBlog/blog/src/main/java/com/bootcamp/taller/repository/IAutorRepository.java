package com.bootcamp.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.taller.model.Autor;

public interface IAutorRepository extends JpaRepository<Autor, Integer>{

}

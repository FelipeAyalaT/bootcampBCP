package com.bootcamp.taller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.taller.model.Autor;
import com.bootcamp.taller.repository.IAutorRepository;
import com.bootcamp.taller.service.IAutorService;

@Service
public class AutorServiceImpl implements IAutorService{

	@Autowired
	private IAutorRepository dao;
	
	@Override
	public Autor registrar(Autor t) {	
		return dao.save(t);
	}
 
	@Override
	public List<Autor> listar() {
		return dao.findAll();
	}

	@Override
	public void eliminar(int id) {
		Optional<Autor> autor = dao.findById(id);
		if (autor.get() != null){
			dao.deleteById(id);
		}
	}

}

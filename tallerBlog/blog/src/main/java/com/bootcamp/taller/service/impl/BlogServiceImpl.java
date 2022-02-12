package com.bootcamp.taller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.taller.model.Autor;
import com.bootcamp.taller.model.Blog;
import com.bootcamp.taller.repository.IAutorRepository;
import com.bootcamp.taller.repository.IBlogRepository;
import com.bootcamp.taller.service.IBlogService;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService{

	@Autowired
	private IBlogRepository dao;
	
	@Autowired
	private IAutorRepository autorRepository;
	
	@Override
	public Blog registrar(Blog t) {
		if(!t.getStatus().equalsIgnoreCase("activo") &&
				!t.getStatus().equalsIgnoreCase("inactivo"))
		{
			return new Blog();
		}
		 Optional<Autor> autor = autorRepository.findById(t.getAutor().getIdAutor());
		 if (autor.get() == null) {
			 return new Blog();
		 }
		 if (!autor.get().isMayorEdad()) {
			 return new Blog();
		 }
		 
		 List<Blog> blogActivos = autor.get().getBlog()
				 .stream()
				 .filter(x->x.getStatus().equals("activo"))
				 .collect(Collectors.toList());
				 
		 if ((blogActivos != null &&
				 blogActivos.size() < 3) || t.getStatus().equals("inactivo")) {
			 return dao.save(t);
		 } 
		 return new Blog();
	}
 
	@Override
	public List<Blog> listar() {
		return dao.findAll();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
}

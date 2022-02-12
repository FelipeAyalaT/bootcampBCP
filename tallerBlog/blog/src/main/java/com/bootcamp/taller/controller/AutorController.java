package com.bootcamp.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.taller.model.Autor;
import com.bootcamp.taller.service.IAutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private IAutorService service;

	@GetMapping
	public List<Autor> listar() {
		return service.listar();
	}
	
	@PostMapping
	public Autor registrar(@RequestBody Autor autor) {
		return service.registrar(autor);
	} 
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
}

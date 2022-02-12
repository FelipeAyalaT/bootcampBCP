package com.bootcamp.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.taller.model.Blog;
import com.bootcamp.taller.service.IBlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private IBlogService service;

	@GetMapping
	public List<Blog> listar() {
		return service.listar();
	}
	
	@PostMapping
	public Blog registrar(@RequestBody Blog blog) {
		return service.registrar(blog);
	} 
}

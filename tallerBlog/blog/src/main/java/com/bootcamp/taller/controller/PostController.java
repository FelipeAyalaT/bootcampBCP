package com.bootcamp.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.taller.model.Post;
import com.bootcamp.taller.service.IPostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private IPostService service;

	@GetMapping
	public List<Post> listar() {
		return service.listar();
	}
	
	@PostMapping
	public Post registrar(@RequestBody Post post) {
		return service.registrar(post);
	} 
}

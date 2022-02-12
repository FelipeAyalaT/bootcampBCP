package com.bootcamp.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.taller.model.Comment;
import com.bootcamp.taller.service.ICommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private ICommentService service;

	@GetMapping
	public List<Comment> listar() {
		return service.listar();
	}
	
	@PostMapping
	public Comment registrar(@RequestBody Comment comment) {
		return service.registrar(comment);
	} 
}

package com.bootcamp.taller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.taller.model.Comment;
import com.bootcamp.taller.model.Post;
import com.bootcamp.taller.repository.ICommentRepository;
import com.bootcamp.taller.repository.IPostRepository;
import com.bootcamp.taller.service.ICommentService;

import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService{

	@Autowired
	private IPostRepository postRepository;
	
	@Autowired
	private ICommentRepository dao;
	
	@Override
	public Comment registrar(Comment t) {
		
		 Optional<Post> post = postRepository.findById(t.getPost().getIdPost());
		 if (post.get() == null) {
			 return new Comment();
		 }
		 
		 if(post.get().getStatus().equalsIgnoreCase("borrador")){
				return new Comment();
		 }
		 
		 return dao.save(t);
		  
	}
 
	@Override
	public List<Comment> listar() {
		return dao.findAll();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
}

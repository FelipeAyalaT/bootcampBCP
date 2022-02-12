package com.bootcamp.taller.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.taller.model.Blog;
import com.bootcamp.taller.model.Post;
import com.bootcamp.taller.repository.IBlogRepository;
import com.bootcamp.taller.repository.IPostRepository;
import com.bootcamp.taller.service.IPostService;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{

	@Autowired
	private IPostRepository dao;
	
	@Autowired
	private IBlogRepository blogRepository;
	
	@Override
	public Post registrar(Post t) {
		if(!t.getStatus().equalsIgnoreCase("borrador") &&
				!t.getStatus().equalsIgnoreCase("publicado"))
		{
			return new Post();
		}
		
		 Optional<Blog> blog = blogRepository.findById(t.getBlog().getIdBlog());
		 if (blog.get() == null) {
			 return new Post();
		 }
		 
		 if (blog.get().getStatus().equalsIgnoreCase("inactivo")) {
			 return new Post();
		 }
		 
		 List<Post> post = blog.get().getPost().stream()
				 .filter(x-> DateTimeFormatter.ofPattern("yyyy-MM-dd").
						 format(x.getDate()).equals(DateTimeFormatter.ofPattern("yyyy-MM-dd")
								 .format(LocalDate.now())) &&
						 x.getStatus().equals("publicado"))
				 .collect(Collectors.toList());
		 
		 if (post.size() > 0 && t.getStatus().equals("publicado")){
			 return new Post();
		 }				
		 
		  return dao.save(t);
		  
	}
 
	@Override
	public List<Post> listar() {
		return dao.findAll();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
}

package com.bootcamp.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.taller.model.Blog;

public interface IBlogRepository extends JpaRepository<Blog, Integer>{

}

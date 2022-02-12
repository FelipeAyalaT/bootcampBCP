package com.bootcamp.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.taller.model.Post;

public interface IPostRepository extends JpaRepository<Post, Integer>{

}

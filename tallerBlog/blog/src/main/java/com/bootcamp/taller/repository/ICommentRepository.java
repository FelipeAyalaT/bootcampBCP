package com.bootcamp.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.taller.model.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Integer>{

}

package com.example.simpleblog.post.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.simpleblog.models.Post;

@Repository	
public interface PostRepository extends CrudRepository<Post, Integer>{
	
	
	public Post findBytitle(String title);
	@Transactional
	public Long deleteBytitle(String title);
}

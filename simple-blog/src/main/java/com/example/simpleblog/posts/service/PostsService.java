package com.example.simpleblog.posts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleblog.models.Post;
import com.example.simpleblog.post.repository.PostRepository;

@Service
public class PostsService {

	@Autowired
	PostRepository postRepository;
	

	public void createPost(Post post) {
		//to create a post we need a..
		//post object
		
		//get the text from the controller and set it to the Post 
		
		//instead of getting the text why not just get a post object and save it directly
		postRepository.save(post);
	}
	
	public void deletePost(String title) {
		postRepository.deleteBytitle(title);
	}
	
	public void editPost(String title) {
		//TODO: impement this 
		
		Post post = getPost(title);
	}
	
	public Post  getPost(String title) {
		return postRepository.findBytitle(title);
	}
	
	public Iterable<Post> getAllPosts(){
		return postRepository.findAll();
	}
}

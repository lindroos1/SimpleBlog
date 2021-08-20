package com.example.simpleblog;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.simpleblog.User.Repository.UserRepository;
import com.example.simpleblog.models.Post;
import com.example.simpleblog.models.UserEntity;
import com.example.simpleblog.posts.service.PostsService;

@Controller
public class controller {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostsService postService;


	@RequestMapping("/")
	public String returnIndex(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		return "index";
	}
	
	@RequestMapping("register")
	public String returnRegister() {
		return "register";
	}
	
	@RequestMapping(value = "registerAction", method=RequestMethod.POST)
	@ResponseBody
	public String registerAction(@RequestParam("name") String Name, @RequestParam("password") String Password) {
		
		//get the name and pass from the request
		
		//create encoder obj
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//crypt the pass
		String encoded = encoder.encode(Password);
		
		//save the encoded pass and the name to the db
		UserEntity entity = new UserEntity();
		entity.setName(Name);
		entity.setPassword(encoded);
		entity.setRole("ROLE_USER");
		userRepository.save(entity);
		System.out.print("Inside registerACtion method");
		return "registered!";
	}
	
	@GetMapping("PostForm")
	public String PostForm() {
		return "postForm";
	}
	
	@PostMapping("CreatePost")
	public String CreatePost(@RequestParam("title") String title, @RequestParam("body") String body) {
		//get the title && body 
		//and save them to a post object
	
		Post post = new Post();
		post.setTitle(title);
		post.setText(body);
		
		postService.createPost(post);
		return "index";
	}

	@GetMapping("getPosts")
	public String getAllPosts(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		return "GetPost";
	}
	
	@GetMapping("getPost")
	public String getPost(Model model, @RequestParam("search") String title) {
		model.addAttribute("post", postService.getPost(title));
		return "GetPost";
	}
	
	@GetMapping("DeleteArticle")
	public String deleteArticle(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		return "delete";
	}
	@PostMapping("PostDeleteArticle")
	@ResponseBody
	public String PostDeleteArticle(@RequestParam("attributes[]") List<String> attributes) {
		for(int i = 0; i< attributes.size(); i++) {
			postService.deletePost(attributes.get(i));
		}
		return "it calls the method!";
	}
	
	@PostMapping("EditPost")
	@ResponseBody
	public String EditPost(@RequestParam("article") String article, Model model) {
		System.out.print("Edit Post method is called ");
		//find the article
		model.addAttribute("post", postService.getPost(article));
		model.addAttribute("atri", "adding && gettin from model works ");
		//send the info to the page && redirect to it
		return "success";
	}
	@GetMapping("EditFormTest")
	private String EditPostTest( Model model) {
		return "editForm";
	}
}

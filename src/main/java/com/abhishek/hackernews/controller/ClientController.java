package com.abhishek.hackernews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.hackernews.model.ResponseComment;
import com.abhishek.hackernews.model.ResponseStory;
import com.abhishek.hackernews.service.APIService;

@RestController
public class ClientController {

	@Autowired
	APIService apiService;
	
	@RequestMapping(value="/top-stories", method = RequestMethod.GET)
	public List<ResponseStory> getTopStories() {
		List<ResponseStory> responseStories = apiService.getTopStories();

		return responseStories;
	} 
	
	@RequestMapping(value="/comments", method = RequestMethod.GET)
	public List<ResponseComment> getComments(@RequestParam("storyId") long storyId) {
		List<ResponseComment> responseComments = apiService.getComments(storyId);
		
		return responseComments;
	}
	
	@RequestMapping(value="/past-stories", method = RequestMethod.GET)
	public List<ResponseStory> getpastStories() {
		List<ResponseStory> responseStories = apiService.getTopStories();
		
		return responseStories;
	}
}

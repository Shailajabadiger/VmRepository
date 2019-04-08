package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.MindtreeMinds;
import com.mindtree.service.MindsServiceInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MindsController {
	
	@Autowired
	private MindsServiceInterface mindsService;

	@PostMapping(value="/create")
	public Mono<MindtreeMinds> create(@RequestBody MindtreeMinds minds ){
		return mindsService.save(minds);
		
	}
	@GetMapping(value="/getall")
	public Flux<MindtreeMinds> getAllList(){
		
		return mindsService.findAllList();
	}
	@GetMapping(value="/getbymid")
	public Mono<MindtreeMinds> getByMid(@RequestParam String mid){
		
		return mindsService.findByMid(mid);	
	}
	@DeleteMapping(value="/deletebymid")
	public Mono<Void> delete(@RequestParam String mid){
		return mindsService.deleteByMid(mid);
		
	}
}



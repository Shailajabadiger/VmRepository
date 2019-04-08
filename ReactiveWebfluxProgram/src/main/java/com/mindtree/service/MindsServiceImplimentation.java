package com.mindtree.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.MindtreeMinds;
import com.mindtree.repository.MindsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MindsServiceImplimentation implements MindsServiceInterface {

	@Autowired
	private MindsRepository mindsRepository;

	@Override
	public Flux<MindtreeMinds> findAllList() {
		
		return mindsRepository.findAll();
	}

	@Override
	public Mono<MindtreeMinds> save(MindtreeMinds minds) {
	
		return mindsRepository.save(minds);
	}

	@Override
	public Mono<MindtreeMinds> findByMid(String mid) {
	
		return mindsRepository.findById(mid);
	}

	@Override
	public Mono<Void> deleteByMid(String mid) {
	
		return mindsRepository.deleteById(mid);
	}

}

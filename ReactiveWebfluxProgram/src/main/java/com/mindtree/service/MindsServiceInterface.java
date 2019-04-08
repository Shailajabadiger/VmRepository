package com.mindtree.service;

import com.mindtree.entity.MindtreeMinds;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MindsServiceInterface {
	Flux<MindtreeMinds> findAllList();

	Mono<MindtreeMinds> save(MindtreeMinds minds);

	Mono<MindtreeMinds> findByMid(String mid);

	Mono<Void> deleteByMid(String mid);
	

}

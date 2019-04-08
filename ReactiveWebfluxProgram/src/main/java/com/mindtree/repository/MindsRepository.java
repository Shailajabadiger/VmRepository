package com.mindtree.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.MindtreeMinds;

@Repository
public interface MindsRepository extends ReactiveMongoRepository<MindtreeMinds, String> {

}

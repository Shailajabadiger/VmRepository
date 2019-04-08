package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>  {

}

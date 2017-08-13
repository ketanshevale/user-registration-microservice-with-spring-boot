package com.google.springrest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.google.springrest.entity.User;

public interface UserRepository extends Repository<User, String>{
	public List<User> findAll();
	public Optional<User> findOne(String userId);
	public Optional<User> findByEmail(String email);
	public User save(User user);
	public void delete(User user);
}

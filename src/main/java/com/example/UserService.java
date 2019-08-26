/**
	Aug 21, 2019
	deepakk
 */
package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author deepakk
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public Page<User> findAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	public User save(User user) {
		return userRepo.save(user);
	}

	public Optional<User> findById(Integer id) {
		return userRepo.findById(id);
	}

	public boolean existsById(Integer id) {
		return userRepo.existsById(id);
	}

	public long count() {
		return userRepo.count();
	}

	public void deleteById(Integer id) {
		userRepo.deleteById(id);
	}

	public void delete(User user) {
		userRepo.delete(user);
	}

	public void deleteAll(Iterable<User> users) {
		userRepo.deleteAll(users);
	}

	public void deleteAll() {
		userRepo.deleteAll();
	}

}

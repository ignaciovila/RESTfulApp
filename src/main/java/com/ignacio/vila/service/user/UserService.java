package com.ignacio.vila.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignacio.vila.model.user.User;
import com.ignacio.vila.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public User getUser(Integer id) {
		return (User) userRepository.findOne(id);
	}

	public boolean saveUser(User user) {
		return userRepository.save(user) != null;
	}

	public void deleteUser(Integer id) {
		userRepository.delete(id);
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}

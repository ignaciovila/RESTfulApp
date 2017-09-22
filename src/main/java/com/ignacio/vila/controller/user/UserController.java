package com.ignacio.vila.controller.user;

import com.ignacio.vila.model.user.User;
import com.ignacio.vila.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/Usuarios")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping("/Usuarios/{id}")
	public User getAllUsers(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/Usuarios/add", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "Success";
	}

	@RequestMapping(value = "/Usuarios/del/{id}", method = RequestMethod.POST)
	public String deleteUser(@RequestParam Integer id) {
		userService.deleteUser(id);
		return "Success";
	}
}

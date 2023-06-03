package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.impl.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.findUsers();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		boolean existe = true;
		existe = userService.removeUser(id);
		if (existe == false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/users/{username}")
	public ResponseEntity<?> activateOrDeactivate(@PathVariable String username) {
		User user = userService.findUser(username);
		if(user.isEnabled()) {
			user.setEnabled(false);
		} else {
			user.setEnabled(true);
		}
		return ResponseEntity.ok(userService.updateUser(user));
	}

}

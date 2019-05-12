package com.rst.boot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rst.boot.domain.UserDTO;
import com.rst.boot.services.UserServices;

@RestController
@RequestMapping("/user")
public class User {
	
	@Autowired
	private UserServices userServices;

	@GetMapping("/all")
	public List<UserDTO> allUsers() {
		return userServices.findAllUsers();
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserDTO Userdata) {
		return userServices.saveUser(Userdata);
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody UserDTO newUserData) {
		return userServices.updateUser(newUserData);
	}
	
	@GetMapping("/find/{id}")
	public Optional<UserDTO> getUserById(@PathVariable Integer id) {
		return userServices.findUById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userServices.deleteUser(id);
	}
	
}

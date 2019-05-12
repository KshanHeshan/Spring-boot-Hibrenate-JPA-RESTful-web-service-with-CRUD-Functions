package com.rst.boot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rst.boot.domain.UserDTO;
import com.rst.boot.repositories.UserRepository;
import com.rst.boot.services.UserServices;

import java.util.*;

@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDTO> findAllUsers() {
		List<UserDTO> allusers = userRepository.findAll();
		return allusers;
		
	}

	@Override
	public String saveUser(UserDTO userdata) {
		userRepository.save(userdata);
		return "Data saved";
	}

	@Override
	public String updateUser(UserDTO newUserData) {
		
		String msg = null;
		
		if(newUserData.getId() != null) {
			userRepository.save(newUserData);
			msg = "Data Updated";
		}
		else {
			msg = "Error";
		}
		return msg;
	}

	@Override
	public Optional<UserDTO> findUById(Integer id) {
			
		return userRepository.findById(id);
		
	}

	@Override
	public void deleteUser(Integer id) {
		 userRepository.deleteById(id);
		
	}



}

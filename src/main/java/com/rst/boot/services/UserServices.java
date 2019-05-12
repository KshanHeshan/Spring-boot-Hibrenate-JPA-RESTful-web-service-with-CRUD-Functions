package com.rst.boot.services;

import java.util.List;
import java.util.Optional;

import com.rst.boot.domain.UserDTO;

public interface UserServices {

	List<UserDTO> findAllUsers();

	String saveUser(UserDTO userdata);

	String updateUser(UserDTO newUserData);

	Optional<UserDTO> findUById(Integer id);

	void deleteUser(Integer id);
	
}

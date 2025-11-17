package com.text.api.services;

import java.util.List;

import com.text.api.dto.UserDTO;

public interface UserService {
	UserDTO addUser(String name);
	List<UserDTO> getUsers();
	UserDTO findByName(String name);
	boolean deleteByName(String name);
	UserDTO updateUser(UserDTO user);
	void deleteAll();
}

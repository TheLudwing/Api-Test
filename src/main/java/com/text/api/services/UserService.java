package com.text.api.services;

import java.util.List;

import com.text.api.dto.UserDTO;

public interface UserService {
	UserDTO addUser(String name);
	List<UserDTO> getUsers();
}

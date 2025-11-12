package com.text.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.text.api.dto.UserDTO;
import com.text.api.entity.User;



@Component
public class UserMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	public User toEntity(UserDTO productoDTO) {
		return modelMapper.map(productoDTO, User.class);
	}
	
	public void toEntity(UserDTO productoDTO, User productoExistente) {
		modelMapper.map(productoDTO, productoExistente);
	}
	
	
	public UserDTO toDTO(User producto) {
		return modelMapper.map(producto, UserDTO.class);
	}
}

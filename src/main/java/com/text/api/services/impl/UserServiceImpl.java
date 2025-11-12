package com.text.api.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.api.dto.UserDTO;
import com.text.api.entity.User;
import com.text.api.mapper.UserMapper;
import com.text.api.repository.UserRepository;
import com.text.api.services.UserService;
import com.text.api.util.NumeroAleatorio;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserMapper  mapper;
 	
	NumeroAleatorio num = new NumeroAleatorio(); 
	
	@Override
	public UserDTO addUser(String name) {
		User usuarioGuardado ;
		/*Optional<User> u = repository.findByName(name);
		User user = new User();

		if(u.isPresent()) {
			user = u.get();
			return mapper.toDTO(user);
		}else {
			user.setName(name);
			try {
				user.setTest(Float.parseFloat(num.generarNumeroUnico()));
			}catch(Exception e){
				user.setTest(0.0f);
				System.out.println("Fallo al generar el numero aleatorio");
			}
			
			repository.save(user);
			return mapper.toDTO(user);
		}*/
		
		Optional<User> u = repository.findByName(name);
	    
	    if(u.isPresent()) {
	        User user = u.get();
	        return mapper.toDTO(user);
	    } else {
	        User user = new User();
	        user.setName(name);  // ← Asegúrate que esto reciba el valor correcto
	        user.setTest(Float.parseFloat(num.generarNumeroUnico()));
	        usuarioGuardado = repository.save(user);
	        return mapper.toDTO(usuarioGuardado);
	    }
	    
		
	}
	
	
	public List<UserDTO> getUsers(){
		List<User> users = repository.findAll();
		
		return users.stream()
				.sorted(Comparator.comparing(User::getTest).reversed())
				.map(mapper::toDTO)
				.toList();
		
		
	}
	
	
	
	
	
	
	
	
	
}

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
	
	   @Override
    public UserDTO updateUser(UserDTO user){
        if (user == null || user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("name is required");
        }

        // Buscar existente para conservar id y otros campos
        UserDTO existingDto = findByName(user.getName());
        if (existingDto == null) {
            throw new IllegalArgumentException("user not found");
        }

		// mapear entidad existente (contiene id), aplicar cambios y guardar
		User entity = mapper.toEntity(existingDto);
		entity.setTest(user.getTest());
		User saved = repository.save(entity);

		// devolver DTO mapeado desde entidad guardada
		return mapper.toDTO(saved);
    }



	@Override
	public List<UserDTO> getUsers(){
		List<User> users = repository.findAll();
		
		return users.stream()
				.sorted(Comparator.comparing(User::getTest).reversed())
				.map(mapper::toDTO)
				.toList();
		
		
	}
	
	@Override
	public UserDTO findByName(String name){
		List<UserDTO> users = getUsers();
		UserDTO user = null;
		for(UserDTO u: users){
			if(u.getName().equals(name)){
				user = u;
			}
		}
		return user;
	}
	
	@Override
	public boolean deleteByName(String name){
		UserDTO u = findByName(name);
		if(u!=null){
			repository.deleteById(u.getId());
			return true;
		}
		return false;
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	
	
	
}

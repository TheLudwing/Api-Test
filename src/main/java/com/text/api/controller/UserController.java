@CrossOrigin(origins = {
    "http://127.0.0.1:5500",
    "https://test-homo.vercel.app"
})package com.text.api.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.text.api.dto.UserDTO;
import com.text.api.dto.UserRequest;
import com.text.api.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {
    "http://127.0.0.1:5500",
    "https://test-homo.vercel.app"
})
public class UserController {

	@Autowired
	UserService service;
	
	
	
	  @PostMapping("/add")
	    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserRequest request) {
	        UserDTO userDTO = service.addUser(request.getName());
	        
	        // Crear response con solo el número
	        Map<String, String> response = new HashMap<>();
	        response.put("numero", String.format("%.2f", userDTO.getTest()));
	        
	        return ResponseEntity.ok(response);
	    }
	
	
	  
	  @GetMapping
		public ResponseEntity<List<UserDTO>> listarProductos() {
			List<UserDTO> users = service.getUsers();
			return ResponseEntity.ok(users);
		}
	  
	  
	  
	
}

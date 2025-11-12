package com.text.api.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private long id;
	
	@NotBlank(message = "El nombre del producto no puede estar vacio")
	private String name;
	
	private float test;



	public float getTest(){
		return this.test;
	}

	public String getName(){
		return this.name;
	}

	public float setTest(float test){
		this.test = test;
	}

	public String setName(String name){
		this.name = name;
	}
	
}

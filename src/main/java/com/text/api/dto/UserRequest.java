package com.text.api.dto;

public class UserRequest {

	   private String name;
	   private float test;

	    // Constructor vacío (necesario para Spring)
	    public UserRequest() {}

	    // Constructor con parámetros
	    public UserRequest(String name) {
	        this.name = name;
	    }

	    // Getter y Setter (obligatorios para que Spring funcione)
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	
		public float getTest(){
			return this.test;
		}
	
	
}

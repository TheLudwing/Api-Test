package com.text.api.dto;

public class UserRequest {

	   private String name;

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
	
	
	
	
}

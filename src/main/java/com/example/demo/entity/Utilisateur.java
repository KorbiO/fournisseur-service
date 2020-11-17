package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
	
	private String id;        
	private String mat;
	private String username; 
	private String password ; 
	private String confirmedPassword ; 
	private String nom;
	private String prenom;
	
	private String role; 
	public String getId( ) {
        return this.mat;
    }

}

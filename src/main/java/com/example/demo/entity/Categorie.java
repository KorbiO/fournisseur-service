package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
	
	private String id;        
	private String mat;
	private String libelleCat;
	
	public String getId( ) {
        return this.mat;
    }

}

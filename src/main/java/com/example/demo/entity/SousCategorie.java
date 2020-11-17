package com.example.demo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SousCategorie {
	
	private String id;        
	private String mat;
	private String libelleSousCat;
	private List <String> valeur ; 
	
	private Categorie categorie ; 
	public String getId( ) {
        return this.mat;
    }

}

package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marque {
	private String idMarq;        
	private String mat;
	private String libelleMarq;
	
	public String getIdMarq( ) {
        return this.mat;
    }
}

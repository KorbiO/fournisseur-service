package com.example.demo.entity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteFlash {
	

	private String id;        
	private String mat;
	private LocalDateTime dateDebVF;
	private LocalDateTime dateFinVF;
	private List<Article> articleVenteFlash ;
	
	public String getId() {
        return this.mat;
    }
}

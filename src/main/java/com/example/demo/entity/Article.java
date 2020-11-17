package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	private String id;        
	private String mat;
	
	private String designtationArt;
	private String descriptionArt;
	private  double prixArt;
	private int qteStockArt;
	private double tauxRemiseArt;
	private String imageName;
	private Marque marqueArt;
	private Boolean isArtVF;	
	private SousCategorie sousCategorieArt;

	private Fournisseur fournisseurArt;
	
//	private ImageModel imageModel ;
	private  double prixArtVF;
    private int qteStockArtVF;
   
	
	public String getId( ) {
        return this.mat;
    }
	

}
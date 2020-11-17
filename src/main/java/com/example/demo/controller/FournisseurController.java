package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;

import com.example.demo.entity.Categorie;

import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.Marque;
import com.example.demo.entity.SousCategorie;
import com.example.demo.entity.VenteFlash;
import com.example.demo.service.FournisseurService;
import com.example.demo.service.RestAdminService;




@RestController
public class FournisseurController {
	
		@Autowired
		private FournisseurService fournisseurService ;
		
		@Autowired
		private RestAdminService restAdminService;
		
		
		
		
		
		/* Gestion des Articles  Ajout + Update + Delete + Affichage */
		
		@PostMapping("/article")
		public Article addArticle (@RequestBody Article article) {
			Article art = new Article();
			
			art.setMat(UUID.randomUUID().toString().replace("-", ""));
			art.setDesigntationArt(article.getDesigntationArt());
			art.setDescriptionArt(article.getDescriptionArt());
			art.setImageName(article.getImageName());
			art.setPrixArt(article.getPrixArt());
			art.setQteStockArt(article.getQteStockArt());
			art.setTauxRemiseArt(article.getTauxRemiseArt());
			art.setIsArtVF(false);
			Marque m = fournisseurService.findMarqueById(article.getMarqueArt().getIdMarq());
			art.setMarqueArt(m);
			SousCategorie sousCat = fournisseurService.findSousCategorieById(article.getSousCategorieArt().getId());
			art.setSousCategorieArt(sousCat);
			Fournisseur f = fournisseurService.findFournisseurById(article.getFournisseurArt().getUsername());
			art.setFournisseurArt(f);
			fournisseurService.addArticle(art);
			return art ;
			
			
		}
		
		

		 @GetMapping("/article")
		public CollectionModel<Article>  listArticles()
		{
			return fournisseurService.findAllArticle();
		} 

		@GetMapping("/article/{id}")
		public  Article getArticle(@PathVariable ("id") String id )
		{
			return fournisseurService.getArticleById(id);
		}
		
		
		@PutMapping("/article/{id}")
		public Article modifyArticle(@RequestBody Article article , @PathVariable("id") String id) {
			
					Article art = new Article();
					art.setMat(article.getMat());
					art.setDesigntationArt(article.getDesigntationArt());
					art.setDescriptionArt(article.getDescriptionArt());
					art.setImageName(article.getImageName());
					art.setPrixArt(article.getPrixArt());
					art.setQteStockArt(article.getQteStockArt());
					art.setTauxRemiseArt(article.getTauxRemiseArt());
					
					Marque m = fournisseurService.findMarqueById(article.getMarqueArt().getIdMarq());
					art.setMarqueArt(m);
					SousCategorie sousCat = fournisseurService.findSousCategorieById(article.getSousCategorieArt().getId());
					art.setSousCategorieArt(sousCat);
					Fournisseur f = fournisseurService.findFournisseurById(article.getFournisseurArt().getUsername());
					art.setFournisseurArt(f);
					
					
						
			fournisseurService.updatArticle(art,id);
			return art;	
		}
		
		@DeleteMapping ("article/{id}")
		public void deleteArticle (@PathVariable("id") String id)
		{
			fournisseurService.deleteArticle(id);	
		}
		
		/* Ajout Marque + list Marque */
		
		@PostMapping("/marque")
		public Marque addMarque (@RequestBody Marque marque )
		{
			Marque m = new Marque(); 
			
			m.setMat(UUID.randomUUID().toString().replace("-", ""));
			m.setLibelleMarq(marque.getLibelleMarq());
			
			fournisseurService.addMarque(m);
			return m ; 
		}
		@GetMapping ("/marque")
		public CollectionModel<Marque> listMarque ()
		{
			return fournisseurService.findAllMarque();
		}
		
		@GetMapping ("/marque/{id}")
		public  Marque getMarque (@PathVariable ("id") String id )
		{
			return fournisseurService.findMarqueById(id);
		}
		
		@PutMapping("/marque/{id}")
		public Marque modifyMarque  (@RequestBody Marque marque, @PathVariable ("id")  String id)
		{
			Marque m = new Marque(); 
			m.setLibelleMarq(marque.getLibelleMarq());
			fournisseurService.updateMarque(m, id);
			return m ;
		}
		
	
		
		
		/* Afiichage + Ajout Sous_Cathegorie */
		
		
		@GetMapping ("/souscategorie")
		public CollectionModel<SousCategorie> listSousCategorie ()
		{
			return fournisseurService.findAllSousCategorie();
		}
		
		@GetMapping ("/souscategorie/{id}")
		public SousCategorie getSousCategorie (@PathVariable ("id") String id )
		{
			return fournisseurService.findSousCategorieById(id);
		}
		
		
		
		/* Ajout + Affichage Categorie */ 
		
		@PostMapping("/categorie")
		public Categorie addCategorie (@RequestBody Categorie categorie )
		{
			Categorie cat = new Categorie(); 
			cat.setId(categorie.getId());
			cat.setMat(categorie.getMat());
			cat.setLibelleCat(categorie.getLibelleCat());
			
			fournisseurService.addCategorie(cat);
			return cat; 
		}
		
	
		@GetMapping ("/categorie")
		public CollectionModel<Categorie> listCategorie ()
		{
			return fournisseurService.findAllCategorie();
		}
		
		@GetMapping ("/categorie/{id}")
		public  Categorie getCategorie (@PathVariable ("id") String id )
		{
			return fournisseurService.findCategorieById(id);
		}
				
		
		/* Modifier Porfil Fournisseur */
		
		
		@GetMapping ("/fournisseur/{id}")
		public Fournisseur findFournisseurById (@PathVariable ("id") String id )
		{
			return fournisseurService.findFournisseurById(id);
		}
		
	
		
		/*    Vente Flash      */
		
		@PostMapping("/venteflash")
        public VenteFlash postVenteFlash (@RequestBody VenteFlash venteFlash )
        {
            VenteFlash v = fournisseurService.findVenteFlashById(venteFlash.getId());
            System.out.println(v.getDateFinVF());
            System.out.println(v.getDateDebVF());
            VenteFlash v1 = new VenteFlash();
            v1.setMat(venteFlash.getMat());
            v1.setId(venteFlash.getId());
            v1.setDateDebVF(v.getDateDebVF());
            v1.setDateFinVF(v.getDateFinVF());
           
            List<Article> a = new ArrayList<>();
            List<Article> c= new ArrayList<>();
           
           
            c=v.getArticleVenteFlash();
           
            System.err.println(c);
            
            a.addAll(venteFlash.getArticleVenteFlash());
            for (Article ar : a) {
            	ar.setIsArtVF(true);
            	ar.setQteStockArt(ar.getQteStockArt() - ar.getQteStockArtVF());
            	fournisseurService.updatArticle(ar, ar.getMat());
            }
            System.err.println(a);
            if (c== null )
            {
                v1.setArticleVenteFlash(a);
            }else {
                c.addAll(a);     
                v1.setArticleVenteFlash(c);
            }
           
            fournisseurService.addArticleventeflash(v1);
            return v1 ;
           
        }
		
		
		@GetMapping ("/venteflash/{id}")
		public VenteFlash findVenteFlashById (@PathVariable ("id") String id )
		{
			return fournisseurService.findVenteFlashById(id);
		}
		
		
		@GetMapping ("/venteflash")
		public CollectionModel<VenteFlash> listVenteFlash ()
		{
			return fournisseurService.findAllVenteFlash();
		}
		
		
	
		
		}
		

		



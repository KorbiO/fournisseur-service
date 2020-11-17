package com.example.demo.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.entity.VenteFlash;

@FeignClient(name = "AdminService")
public interface RestAdminService {
	
	@GetMapping("/venteflash/{id}")
	public VenteFlash findVentFlashById(@PathVariable("id") String id);
}

package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.DonorDTO;
import com.pack.service.IDonorService;



@RestController
public class DonorRestController {
	@Autowired
	IDonorService  service;
	
	
	
	@GetMapping("/Donors")
	public  ResponseEntity<List<DonorDTO>>  fetchAllDonors() {
		List<DonorDTO>  donorDTOList = service.getAllDonorsList();
		return  new  ResponseEntity<List<DonorDTO>>(donorDTOList, HttpStatus.OK);
	}
	
	
	@GetMapping("/Donor/{email}")
	public  DonorDTO  fetDonorByEmail(@PathVariable String email) {
		return  service.getDonorById(email);
	}
	
	
	
	@PostMapping("/Donor/create")
	public  String  createNewDonor(@RequestBody  DonorDTO  dto)
	{
		boolean flag=service.saveDonor(dto);
		if(flag==true) {
			return "Donor is saved";
		}
		else {
			return "Donor already exists";
		}
		
	}
	
	
	@PutMapping("/Donor/update")
	public  String  updateDonor(@RequestBody  DonorDTO  dto)
	{
		boolean flag=service.updateDonorById(dto);
		if(flag==true) {
			return "Donor is updated";
		}
		else {
			return "Donor doesn't exists";
		}
		
	}
	
	
	@DeleteMapping("/Donor/delete")
	public  String  deleteDonor(@RequestParam String email) {
		boolean flag=service.deleteDonorById(email);
		if(flag==true) {
			return "Donor is deleted";
		}
		else {
			return  "Donor doesn't exist";
		}
	}

}

package com.pack.service;

import java.util.List;

import com.pack.dto.DonorDTO;
import com.pack.entity.Donor;

public interface IDonorService {
	
	List<DonorDTO>  getAllDonorsList();
	
	DonorDTO  getDonorById(String email);
	
	boolean  updateDonorById(DonorDTO dto);
	
	boolean  saveDonor(DonorDTO  dto);
	
	boolean  deleteDonorById(String email);
}

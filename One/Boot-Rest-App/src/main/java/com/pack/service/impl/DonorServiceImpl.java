package com.pack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dto.DonorDTO;
import com.pack.entity.Donor;
import com.pack.repository.DonorRepository;
import com.pack.service.IDonorService;

@Service
public class DonorServiceImpl implements IDonorService {
	@Autowired
	DonorRepository   donorRepo;

	@Override
	public List<DonorDTO> getAllDonorsList() {
		List<Donor> donorList = donorRepo.findAll();
		
		List<DonorDTO>  donorDTOList =new  ArrayList<>();
		
		for(Donor  donor : donorList) {
			DonorDTO  dto=new  DonorDTO();
			BeanUtils.copyProperties(donor,dto);
			donorDTOList.add(dto);
		}
		return   donorDTOList;
	}

	@Override
	public DonorDTO getDonorById(String email) {
		Optional<Donor>  opt = donorRepo.findById(email);
		Donor  donor = opt.get();
		DonorDTO  dto=new  DonorDTO();
		BeanUtils.copyProperties(donor, dto);
		return dto;
		
	}

	@Override
	public boolean updateDonorById(DonorDTO  dto) {
		boolean flag=donorRepo.existsById(dto.getEmail());
		if(flag==true) {
			Donor  donor=new  Donor();
			BeanUtils.copyProperties(dto, donor);
			donorRepo.saveAndFlush(donor);
			return  true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean saveDonor(DonorDTO dto) {
		boolean flag=donorRepo.existsById(dto.getEmail());
		if(flag==false) {
			Donor  donor=new  Donor();
			BeanUtils.copyProperties(dto, donor);
			donorRepo.save(donor);
			return  true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean deleteDonorById(String email) {
		boolean flag=donorRepo.existsById(email);
		if(flag==true) {
			donorRepo.deleteById(email);;;;;;;;;
			return  true;
		}
		else {
			return false;
		}
	}

}

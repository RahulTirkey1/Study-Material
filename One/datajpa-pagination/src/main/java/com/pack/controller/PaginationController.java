package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.entity.Employee;
import com.pack.service.IEmpService;

@Controller
public class PaginationController {
	@Autowired 
	IEmpService   service;
	
	@GetMapping("/getEmployees")
	public   String   pageEmployees(@RequestParam(value="pageIndex", defaultValue="0") int  pageIndex, Model  model)
	{
		Page<Employee>   page= service.getEmployees(pageIndex);
		List<Employee>  empList = page.getContent();
		boolean  previous=page.hasPrevious();
		boolean  next=page.hasNext();
		int  currentPageNumber=page.getNumber();
		
		model.addAttribute("employees",  empList);
		model.addAttribute("previous", previous);
		model.addAttribute("next", next);
		model.addAttribute("cpn", currentPageNumber);
		return  "ShowEmployees";		
	}

}

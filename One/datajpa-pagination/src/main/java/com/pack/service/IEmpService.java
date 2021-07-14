package com.pack.service;

import org.springframework.data.domain.Page;

import com.pack.entity.Employee;

public interface IEmpService {
	Page<Employee>     getEmployees(int  pageIndex);
}

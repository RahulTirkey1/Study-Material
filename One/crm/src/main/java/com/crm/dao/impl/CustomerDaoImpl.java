package com.crm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crm.dao.CustomerDao;
import com.crm.model.CustomerBean;
import com.crm.model.Gender;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	JdbcTemplate  jdbcTemplate;
	
	@Override
	public boolean addCustomer(CustomerBean customerBean) {
		int count = jdbcTemplate.queryForObject("select  count(*) from  customers where  email=?", Integer.class, customerBean.getEmail());
		if(count==1) {
			return  false;
		}
		else {
			String  gender="";
			if(customerBean.getGender() == Gender.MALE)
			{
				gender="male";
			}
			else if(customerBean.getGender()==Gender.FEMALE) {
				gender="female";
			}
			else {
				gender="others";
			}
			
			jdbcTemplate.update("insert into customers(email,firstname,lastname,password,gender,country)  values(?,?,?,?,?,?)", customerBean.getEmail(),customerBean.getFirstName(),customerBean.getLastName(),customerBean.getPassword(),gender,customerBean.getCountry());
			return true;
		}
	}

	@Override
	public boolean loginCustomer(String email, String password) {
		int count=jdbcTemplate.queryForObject("select count(*) from customers  where  email=?  and  password=?", Integer.class, email, password);
		if(count==1) {
			return  true;
		}
		else {
			return  false;
		}
	}

}

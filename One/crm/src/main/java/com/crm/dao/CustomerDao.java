package com.crm.dao;

import com.crm.model.CustomerBean;

public interface CustomerDao {
	boolean  addCustomer(CustomerBean  customerBean);
	boolean  loginCustomer(String email,String password);

}

package com.myafternoonbank1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myafternoonbank1.dao.MyBankingDAOInterface;
import com.myafternoonbank1.entity.Employee;

@Service
@Transactional
public class MyBankingService implements MyBankingServiceInterface{
	
	@Autowired
	private MyBankingDAOInterface mDao;

	@Override
	public Employee createProfileService(Employee emp) {
		mDao.save(emp);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployeeService() {
		// TODO Auto-generated method stub
		return mDao.findAll();
	}

	@Override
	public String deleteProfileService(String email) {
		mDao.deleteById(email);
		return "record deleted";
	}

	@Override
	public Employee updateProfileService(Employee emp) {
		mDao.saveAndFlush(emp);
		return emp;
	}

}















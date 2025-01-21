package com.myafternoonbank1.service;

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

}















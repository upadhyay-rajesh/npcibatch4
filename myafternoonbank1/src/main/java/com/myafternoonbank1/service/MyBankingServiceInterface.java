package com.myafternoonbank1.service;

import java.util.List;

import com.myafternoonbank1.entity.Employee;

public interface MyBankingServiceInterface {

	Employee createProfileService(Employee emp);

	List<Employee> getAllEmployeeService();

	String deleteProfileService(String email);

	Employee updateProfileService(Employee emp);

}

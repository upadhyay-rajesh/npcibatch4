package com.myafternoonbank1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myafternoonbank1.entity.Employee;
import com.myafternoonbank1.service.MyBankingServiceInterface;

@RestController
@RequestMapping("/api/v1/employees")
public class MyBankingController {
	
	@Autowired
	private MyBankingServiceInterface mService;
	
	@GetMapping  //retrive
	public List<Employee> findAllEmployee() {
		return mService.getAllEmployeeService();
	}
	
	@PostMapping //create
	public String register(@RequestBody Employee emp) { //using @RequestBody API will take data from client
		
		Employee emp1 = mService.createProfileService(emp);
		
		return "registration success "+emp.getName()+"  "+emp.getPassword()+"  "+emp.getEmail()+"  "+emp.getAddress();
	}
	
	@PutMapping("/{uid}") //update
	public Employee update(@PathVariable("uid") String email,@RequestBody Employee emp) {
		emp.setEmail(email);
		return mService.updateProfileService(emp);
	}
	
	@DeleteMapping("/{uid}") //delete
	public String remove(@PathVariable("uid") String email) {
		return mService.deleteProfileService(email);
	}
}

















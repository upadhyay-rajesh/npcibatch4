package com.myafternoonbank1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myafternoonbank1.entity.Employee;

@RestController
public class MyBankingController {
	
	@GetMapping("displayAllEmployee")  //retrive
	public String findAllEmployee() {
		return "Welcome to REST API!";
	}
	
	@PostMapping("createProfile") //create
	public String register(@RequestBody Employee emp) { //using @RequestBody API will take data from client
		return "registration success "+emp.getName()+"  "+emp.getPassword()+"  "+emp.getEmail()+"  "+emp.getAddress();
	}
	
	@PutMapping("editProfile") //update
	public String update() {
		return "profile updated";
	}
	
	@DeleteMapping("deleteProfile/{uid}") //delete
	public String remove(@PathVariable("uid") String email) {
		return "profile deleted for    "+email;
	}
}

















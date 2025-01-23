package com.apiconsumer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apiconsumer.dto.Employee;

@RestController
@RequestMapping("/api/v1/consumer")
public class MyConsumerController {

	@GetMapping
	public List<Employee> displayAll(){
		RestTemplate rtemp=new RestTemplate();
		
		List<Employee> ee=  rtemp.getForObject("http://localhost:10000/api/v1/employees", List.class);
		
		return ee;
	}
	@PostMapping
	public String createPost(@RequestBody Employee ee) {

		//List<ServiceInstance> ll = ds.getInstances("MYBANKING");

		//ServiceInstance myinstance = ll.get(0);

		//String uri = myinstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject("http://localhost:10000/api/v1/employees", ee, String.class);
		return response;
	}

	@PutMapping("/{id}")
	public Employee updatePost(@RequestBody Employee ee, @PathVariable String id) {

	//	List<ServiceInstance> ll = ds.getInstances("MYBANKING");

	//	ServiceInstance myinstance = ll.get(0);

	//	String uri = myinstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:10000/api/v1/employees" + id, ee);
		return ee;
	}

	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable String id) {

	//	List<ServiceInstance> ll = ds.getInstances("MYBANKING");

	//	ServiceInstance myinstance = ll.get(0);

	//	String uri = myinstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:10000" + "/api/v1/employees" + id);

		return "deleted";
	}
}

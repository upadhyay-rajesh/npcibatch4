package com.apiconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	
	@Autowired
	DiscoveryClient ds;
	
	@Autowired
	RestTemplate rtemp;

	@GetMapping
	public List<Employee> displayAll(){
		
		 List<ServiceInstance> ll=  ds.getInstances("MYAFTERNOONBANK1");
		
		 ServiceInstance ss= ll.get(0);
		 
		 String url=ss.getUri().toString();
		
		
		//RestTemplate rtemp=new RestTemplate();
		
		List<Employee> ee=  rtemp.getForObject(url+"/api/v1/employees", List.class);
		
		return ee;
	}
	@PostMapping
	public String createPost(@RequestBody Employee ee) {

		List<ServiceInstance> ll = ds.getInstances("MYAFTERNOONBANK1");

		ServiceInstance myinstance = ll.get(0);

		String url = myinstance.getUri().toString();

		//RestTemplate restTemplate = new RestTemplate();
		String response = rtemp.postForObject(url+"/api/v1/employees", ee, String.class);
		return response;
	}

	@PutMapping("/{id}")
	public Employee updatePost(@RequestBody Employee ee, @PathVariable String id) {

		List<ServiceInstance> ll = ds.getInstances("MYAFTERNOONBANK1");

		ServiceInstance myinstance = ll.get(0);

		String url = myinstance.getUri().toString();

	//	RestTemplate restTemplate = new RestTemplate();
		rtemp.put(url+"/api/v1/employees/" + id, ee);
		return ee;
	}

	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable String id) {

		List<ServiceInstance> ll = ds.getInstances("MYAFTERNOONBANK1");

		ServiceInstance myinstance = ll.get(0);

		String url = myinstance.getUri().toString();

		//RestTemplate restTemplate = new RestTemplate();
		rtemp.delete(url+"/api/v1/employees/" + id);

		return "deleted";
	}
}

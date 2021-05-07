package br.com.pagaleve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import br.com.pagaleve.PagaleveApplication;
import br.com.pagaleve.model.Customer;
import br.com.pagaleve.service.CustomerService;


@RestController
@RequestMapping(PagaleveApplication.PATH +"/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@RequestBody Customer customer) {
		return service.save(customer);
	}
	
	@PutMapping(value="/{id}")
	public Customer update(@PathVariable("id") String id, @RequestBody Customer customer) {
		service.findById(id);
		customer.setId(id);
		return service.save(customer);
	}
	
	@DeleteMapping(value="/{id}")
	public Customer delete(@PathVariable("id") String id) {
		return service.delete(id);
	}
	
	@GetMapping(value="/{id}")
	public Customer update(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value="/search/{filtro}")
	public List<Customer> find(@PathVariable("filtro") String filtro) {
		return service.find(filtro);
	}
}

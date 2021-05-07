package br.com.pagaleve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pagaleve.exception.ResourceNotFoundException;
import br.com.pagaleve.model.Customer;
import br.com.pagaleve.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	public Customer save(Customer customer) {
		return repository.save(customer);
	}
	
	public List<Customer> findAll(){
		return repository.findAll();
	}
	
	public List<Customer> find(String filtro){
		if(filtro == null) {
			return repository.findAll();	
		}else {
			return repository.findByFirstNameLikeOrLastNameLikeOrEmailLikeOrFoneLike(filtro,filtro,filtro,filtro);
		}
	}
	
	public Customer findById(String id) {
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer", id));
	}
	
	public Customer delete(String id) {
		Customer customer = findById(id);
		repository.delete(customer);
		return customer;
	}
}

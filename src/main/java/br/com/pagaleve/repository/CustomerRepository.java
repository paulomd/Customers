package br.com.pagaleve.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.pagaleve.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	List<Customer> findByFirstNameLikeOrLastNameLikeOrEmailLikeOrFoneLike(String firstName, String lastName, String email, String fone);
}



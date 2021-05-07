package br.com.pagaleve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pagaleve.model.Customer;
import br.com.pagaleve.service.CustomerService;

@SpringBootApplication
public class PagaleveApplication implements CommandLineRunner {

	@Autowired
	private CustomerService service;
	
	public static final String PATH = "/api/v1";

	public static void main(String[] args) {
		SpringApplication.run(PagaleveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Customer> all = service.findAll();
		if (all == null || all.size() == 0) {
			service.save(new Customer("Arthur", "Oliveira"));
			service.save(new Customer("Diana", "Oliveira"));
			service.save(new Customer("Lauri", "Oliveira"));
			service.save(new Customer("Elira", "Oliveira"));
			service.save(new Customer("Antonio", "Oliveira"));
			service.save(new Customer("Deise", "Fernandes"));
			service.save(new Customer("Neusa", "Fernandes"));
			service.save(new Customer("Vanderlei", "Fernandes"));
		}

	}

}

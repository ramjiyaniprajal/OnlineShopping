package com.ebusiness.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebusiness.onlineshopping.model.Customer;
import com.ebusiness.onlineshopping.service.CustomerService;
@Transactional
@RestController
public class CustomerController {

	@Autowired
	private CustomerService CustomerService;

	/*---Add new Customer---*/
	@PostMapping("/Customer")
	public ResponseEntity<?> save(@RequestBody Customer Customer) {
		long id = CustomerService.save(Customer);
		return ResponseEntity.ok().body("New Customer has been saved with ID:" + id);
	}

	/*---Get a Customer by id---*/
	@GetMapping("/Customer/{id}")
	public ResponseEntity<Customer> get(@PathVariable("id") long id) {
		Customer Customer = CustomerService.get(id);
		return ResponseEntity.ok().body(Customer);
	}

	/*---get all Customers---*/
	@GetMapping("/Customer")
	public ResponseEntity<List<Customer>> list() {
		List<Customer> Customers = CustomerService.list();
		return ResponseEntity.ok().body(Customers);
	}

	/*---Update a Customer by id---*/
	@PutMapping("/Customer/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Customer Customer) {
		CustomerService.update(id, Customer);
		return ResponseEntity.ok().body("Customer has been updated successfully.");
	}

	/*---Delete a Customer by id---*/
	@DeleteMapping("/Customer/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		CustomerService.delete(id);
		return ResponseEntity.ok().body("Customer has been deleted successfully.");
	}
}
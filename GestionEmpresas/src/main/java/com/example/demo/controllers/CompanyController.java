package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.User;
import com.example.demo.model.CompanyModel;
import com.example.demo.services.CompanyService;
import com.example.demo.services.impl.UserService;

@RestController
@RequestMapping("/api")
public class CompanyController {
	@Autowired
	@Qualifier("companyService")
	private CompanyService companyService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@DeleteMapping("/company/companies/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable int id) {
		User user = companyService.findCompanyById(id).getUser();
		boolean exist = true;
		exist = userService.removeUser(Integer.parseInt(Long.toString(user.getId())));
		exist = companyService.removeCompany(id);
		if (exist == false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/company/companies")
	public ResponseEntity<?> insertCompany(@RequestBody CompanyModel company) {
		User user = userService.findUser(company.getName());
		company.setUser(userService.transform(user));
		companyService.addCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(company);
	}

	@GetMapping("/companies")
	public ResponseEntity<?> getCompanies() {
		List<Company> companies = companyService.findCompanies();
		if (companies.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(companies);
		}
	}

	@GetMapping("/companies/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable int id) {
		Company company = companyService.findCompanyById(id);
		if (company == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(company);
		}
	}
	
	@GetMapping("/company/companies/{username}")
	public ResponseEntity<?> getCompanyByUser(@PathVariable String username) {
		Company company = companyService.findCompanyByUser(username);
		if (company == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(company);
		}
	}

	@PutMapping("/company/companies/{id}")
	public ResponseEntity<?> updateCompanyById(@PathVariable int id, @RequestBody CompanyModel company) {
		User user = userService.findUser(company.getName());
		company.setUser(userService.transform(user));
		return ResponseEntity.ok(companyService.updateCompany(company));
	}
}

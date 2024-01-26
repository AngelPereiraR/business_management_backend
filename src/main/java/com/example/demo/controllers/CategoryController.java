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

import com.example.demo.entity.Category;
import com.example.demo.entity.Company;
import com.example.demo.services.CategoryService;
import com.example.demo.services.CompanyService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("companyService")
	private CompanyService companyService;

	@PostMapping("/company/{id}/categories")
	public ResponseEntity<?> insertCategory(@PathVariable int id, @RequestBody Category category) {
		Company company = companyService.findCompanyById(id);
		category.setCompany(company);
		categoryService.addCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}

	@DeleteMapping("/company/categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		boolean exist = true;
		exist = categoryService.removeProductsAndCategory(id);
		if (exist == false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/company/{idCompany}/categories/{idCategory}")
	public ResponseEntity<?> updateCategoryById(@PathVariable int idCompany, @PathVariable int idCategory, @RequestBody Category category) {
		Company company = companyService.findCompanyById(idCompany);
		category.setCompany(company);
		return ResponseEntity.ok(categoryService.updateCategory(category));

	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id) {
		Category category = categoryService.findCategoryById(id);
		if (category == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(category);
		}
	}

	@GetMapping("/company/{id}/categories")
	public ResponseEntity<?> getCategories(@PathVariable int id) {
		Company company = companyService.findCompanyById(id);
		List<Category> category = company.getCategories();
		if (category.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(category);
		}
	}

}

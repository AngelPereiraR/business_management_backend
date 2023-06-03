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
import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;
import com.example.demo.services.CategoryService;
import com.example.demo.services.CompanyService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("companyService")
	private CompanyService companyService;

	@DeleteMapping("/company/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		boolean existe = true;
		existe = productService.removeProduct(id);
		if (existe == false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/company/categories/{id}/products")
	public ResponseEntity<?> deleteAllProducts(@PathVariable int id) {
		boolean exist = true;
		exist = productService.removeProductsOfCategory(id);
		if (exist == false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/company/{idCompany}/categories/{idCategory}/product")
	public ResponseEntity<?> insertProduct(@PathVariable int idCompany, @PathVariable int idCategory, @RequestBody Product product) {
		Company company = companyService.findCompanyById(idCompany);
		Category category = categoryService.findCategoryById(idCategory);
		product.setCompany(company);
		product.setCategory(category);
		productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

	@GetMapping("/categories/{id}/products")
	public ResponseEntity<?> getProductsByCategory(@PathVariable int id) {
		List<Product> products = productService.listProductsByCategory(id);
		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(products);
		}
	}

	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {

		List<Product> products = productService.listProducts();
		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(products);
		}
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id) {
		ProductModel product = productService.findProductByIdModel(id);
		if (product == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(product);
		}
	}

	@PutMapping("/company/{idCompany}/categories/{idCategory}/products/{idProduct}")
	public ResponseEntity<?> updateProductById(@PathVariable int idCompany, @PathVariable int idCategory, @PathVariable int idProduct, @RequestBody Product product) {
		Company company = companyService.findCompanyById(idCompany);
		Category category = categoryService.findCategoryById(idCategory);
		product.setCompany(company);
		product.setCategory(category);
		return ResponseEntity.ok(productService.updateProduct(product));
	}
	
	@GetMapping("/companies/{id}/products")
	public ResponseEntity<?> getProductsByCompany(@PathVariable int id) {
		List<Product> products = productService.listProductsByCompany(id);
		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(products);
		}
	}

}

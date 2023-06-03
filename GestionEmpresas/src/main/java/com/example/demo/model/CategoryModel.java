package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class CategoryModel {

	private long id;
	
	private String name;
	
	private String description;
	
	@JsonManagedReference(value="productsCategory")
	@JsonIgnore
	private List<ProductModel> products;
	
	@JsonBackReference(value="categoriesCompany")
	private CompanyModel company;

	public CategoryModel() {
		super();
	}

	public CategoryModel(long id, String name, String description, List<ProductModel> products, CompanyModel company) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", name=" + name + ", description=" + description + ", products=" + products
				+ ", company=" + company + "]";
	}
}

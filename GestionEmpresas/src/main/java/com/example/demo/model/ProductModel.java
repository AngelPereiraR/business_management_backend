package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ProductModel {
	
	private long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	@JsonBackReference(value="productsCategory")
	private CategoryModel category;
	
	@JsonBackReference(value="productsCompany")
	private CompanyModel company;
	
	public ProductModel() {
		super();
	}

	public ProductModel(long id, String name, String description, double price, CategoryModel category,
			CompanyModel company) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", company=" + company + "]";
	}
}

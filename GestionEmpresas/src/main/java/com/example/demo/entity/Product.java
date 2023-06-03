package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	@JsonBackReference(value="productsCategory")
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@JsonBackReference(value="productsCompany")
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	
	@ManyToMany
	@JsonIgnore
	private List<OrderProduct> orders;
	
	public Product() {
		super();
	}

	public Product(long id, String name, String description, double price, Category category,
			Company company, List<OrderProduct> orders) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.company = company;
		this.orders = orders;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<OrderProduct> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderProduct> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", company=" + company + ", orders=" + orders + "]";
	}
}

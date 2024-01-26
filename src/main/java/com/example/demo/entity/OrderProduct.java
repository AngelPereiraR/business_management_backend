package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderProduct {

	@Id
	@GeneratedValue
	private long id;
	
	private double finalPrice;
	
	private String companyName;
	
	private String userUsername;
	
	private List<String> quantities;
	
	@JsonManagedReference(value="orderCompany")
	@ManyToOne
	@JsonIgnore
	private Company company;
	
	@JsonManagedReference(value="orderUser")
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
	private List<Product> products;

	public OrderProduct() {
		super();
	}

	public OrderProduct(long id, double finalPrice, String companyName, String userUsername, List<String> quantities, Company company,
			User user, List<Product> products) {
		super();
		this.id = id;
		this.finalPrice = finalPrice;
		this.companyName = companyName;
		this.userUsername = userUsername;
		this.quantities = quantities;
		this.company = company;
		this.user = user;
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public List<String> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<String> quantities) {
		this.quantities = quantities;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", finalPrice=" + finalPrice + ", companyName=" + companyName
				+ ", userUsername=" + userUsername + ", quantities=" + quantities + ", company=" + company + ", user="
				+ user + ", products=" + products + "]";
	}
}

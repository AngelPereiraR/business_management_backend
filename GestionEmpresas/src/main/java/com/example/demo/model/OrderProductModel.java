package com.example.demo.model;

import java.util.List;

public class OrderProductModel {

	private long id;
	
	private List<ProductModel> products;
	
	private CompanyModel company;
	
	private UserModel user;

	public OrderProductModel() {
		super();
	}

	public OrderProductModel(long id, List<ProductModel> products, CompanyModel company, UserModel user) {
		super();
		this.id = id;
		this.products = products;
		this.company = company;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", products=" + products + ", company=" + company + ", user=" + user + "]";
	}
}

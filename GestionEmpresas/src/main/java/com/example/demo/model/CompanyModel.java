package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class CompanyModel {

	private long id;
	
	private String name;
	
	private String description;
	
	@JsonManagedReference(value="productsCompany")
	private List<ProductModel> products;
	
	@JsonManagedReference(value="categoriesCompany")
	private List<CategoryModel> categories;
	
	@JsonManagedReference(value="suggestionsCompany")
	private List<SuggestionModel> suggestions;
	
	@JsonBackReference(value="userCompany")
	private UserModel user;

	public CompanyModel() {
		super();
	}

	public CompanyModel(long id, String name, String description, List<ProductModel> products, List<CategoryModel> categories, List<SuggestionModel> suggestions, UserModel user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
		this.categories = categories;
		this.suggestions = suggestions;
		this.user = user;
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

	public List<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}

	public List<SuggestionModel> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<SuggestionModel> suggestions) {
		this.suggestions = suggestions;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CompanyModel [id=" + id + ", name=" + name + ", description=" + description + ", products=" + products
				+ ", categories=" + categories + ", suggestions=" + suggestions + ", user=" + user + "]";
	}
}

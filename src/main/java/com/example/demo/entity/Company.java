package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String description;
	
	@JsonManagedReference(value="productsCompany")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Product> products;
	
	@JsonManagedReference(value="categoriesCompany")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Category> categories;
	
	@JsonManagedReference(value="suggestionsCompany")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Suggestion> suggestions;
	
	@JsonBackReference(value="userCompany")
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@JsonBackReference(value="orderCompany")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
	private List<OrderProduct> order;

	public Company() {
		super();
	}

	public Company(long id, String name, String description, List<Product> products, List<Category> categories, List<Suggestion> suggestions, User user, List<OrderProduct> order) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
		this.categories = categories;
		this.suggestions = suggestions;
		this.user = user;
		this.order = order;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderProduct> getOrder() {
		return order;
	}

	public void setOrder(List<OrderProduct> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", products=" + products
				+ ", categories=" + categories + ", suggestions=" + suggestions + ", user=" + user + ", order=" + order + "]";
	}
}

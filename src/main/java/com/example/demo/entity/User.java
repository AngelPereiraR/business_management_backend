package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BusinessUser")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "userLikes")
	@JsonIgnore
	private List<Favorite> favoriteLikes;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "userDislikes")
	@JsonIgnore
	private List<Favorite> favoriteDislikes;
	
	@JsonManagedReference(value="userSuggestion")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Suggestion> suggestions;
	
	@JsonBackReference(value="userCompany")
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Company company;
	
	@JsonBackReference(value="orderUser")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderProduct> order;
	
	private String role;
	
	private boolean enabled;
	
	private String token;

	public User() {
		super();
	}

	public User(long id, String email, String username, String password, List<Favorite> favoriteLikes, List<Favorite> favoriteDislikes,
			List<Suggestion> suggestions, Company company, String role, boolean enabled, String token, List<OrderProduct> order) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.favoriteLikes = favoriteLikes;
		this.favoriteDislikes = favoriteDislikes;
		this.suggestions = suggestions;
		this.company = company;
		this.role = role;
		this.enabled = enabled;
		this.token = token;
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favorite> getFavoriteLikes() {
		return favoriteLikes;
	}

	public void setFavoriteLikes(List<Favorite> favoriteLikes) {
		this.favoriteLikes = favoriteLikes;
	}

	public List<Favorite> getFavoriteDislikes() {
		return favoriteDislikes;
	}

	public void setFavoriteDislikes(List<Favorite> favoriteDislikes) {
		this.favoriteDislikes = favoriteDislikes;
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<OrderProduct> getOrder() {
		return order;
	}

	public void setOrder(List<OrderProduct> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + ", favoriteLikes="
				+ favoriteLikes + ", favoriteDislikes=" + favoriteDislikes + ", suggestions=" + suggestions + ", company=" + company + ", role="
				+ role + ", enabled=" + enabled + ", token=" + token + ", order=" + order + "]";
	}
}

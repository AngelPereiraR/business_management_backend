package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class UserModel {
	
	private long id;
	
	private String email;
	
	private String username;
	
	private String password;
	
	@JsonIgnore
	private List<FavoriteModel> favoriteLikes;
	
	@JsonIgnore
	private List<FavoriteModel> favoriteDislikes;
	
	@JsonManagedReference(value="userSuggestion")
	@JsonIgnore
	private List<SuggestionModel> suggestions;
	
	@JsonBackReference(value="userCompany")
	private Company company;
	
	private String role;
	
	private boolean enabled;
	
	private String token;

	public UserModel() {
		super();
	}

	public UserModel(long id, String email, String username, String password, List<FavoriteModel> favoriteLikes, List<FavoriteModel> favoriteDislikes, 
			List<SuggestionModel> suggestions, Company company, String role, boolean enabled, String token) {
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

	public List<FavoriteModel> getFavoriteLikes() {
		return favoriteLikes;
	}

	public void setFavoriteLikes(List<FavoriteModel> favoriteLikes) {
		this.favoriteLikes = favoriteLikes;
	}

	public List<FavoriteModel> getFavoriteDislikes() {
		return favoriteDislikes;
	}

	public void setFavoriteDislikes(List<FavoriteModel> favoriteDislikes) {
		this.favoriteDislikes = favoriteDislikes;
	}

	public List<SuggestionModel> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<SuggestionModel> suggestions) {
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

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", favoriteLikes=" + favoriteLikes + ", favoriteDislikes=" + favoriteDislikes + ", suggestions=" + suggestions + ", company=" + company + ", role=" + role
				+ ", enabled=" + enabled + ", token=" + token + "]";
	}
}

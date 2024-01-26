package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class SuggestionModel {
	
	private long id;
	
	private String commentary;
	
	private String state;
	
	private String username;
	
	@JsonBackReference(value="userSuggestion")
	private UserModel user;
	
	@JsonBackReference(value="suggestionsCompany")
	private CompanyModel company;

	@JsonManagedReference(value="suggestionsFavorite")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "suggestion")
	@JsonIgnore
	private List<FavoriteModel> favorite;

	public SuggestionModel() {
		super();
	}

	public SuggestionModel(long id, String commentary, String state, String username, UserModel user, CompanyModel company, List<FavoriteModel> favorite) {
		super();
		this.id = id;
		this.commentary = commentary;
		this.state = state;
		this.username = username;
		this.user = user;
		this.company = company;
		this.favorite = favorite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

	public List<FavoriteModel> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<FavoriteModel> favorite) {
		this.favorite = favorite;
	}

	@Override
	public String toString() {
		return "SuggestionModel [id=" + id + ", commentary=" + commentary + ", state=" + state + ", username=" + username
				+ ", user=" + user + ", company=" + company + ", favorite=" + favorite + "]";
	}

}

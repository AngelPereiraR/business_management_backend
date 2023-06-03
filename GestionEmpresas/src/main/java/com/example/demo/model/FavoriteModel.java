package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class FavoriteModel {
	
	private long id;
	
	@JsonBackReference(value="suggestionsFavorite")
	@ManyToOne
	@JoinColumn(name = "suggestionId")
	private SuggestionModel suggestion;
	
	@JsonBackReference(value="userFavorite")
	@ManyToMany
	private List<UserModel> users;

	public FavoriteModel() {
		super();
	}

	public FavoriteModel(long id, SuggestionModel suggestion, List<UserModel> users) {
		super();
		this.id = id;
		this.suggestion = suggestion;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SuggestionModel getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(SuggestionModel suggestion) {
		this.suggestion = suggestion;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "FavoriteModel [id=" + id + ", suggestion=" + suggestion + ", users=" + users + "]";
	}
	
}

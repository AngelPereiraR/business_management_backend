package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorite {
	
	@Id
	@GeneratedValue
	private long id;
	
	@JsonBackReference(value="suggestionsFavorite")
	@ManyToOne
	@JoinColumn(name = "suggestionId")
	private Suggestion suggestion;
	
	@ManyToMany
	private List<User> userLikes;
	
	@ManyToMany
	private List<User> userDislikes;

	public Favorite() {
		super();
	}

	public Favorite(long id, Suggestion suggestion, List<User> userLikes, List<User> userDislikes) {
		super();
		this.id = id;
		this.suggestion = suggestion;
		this.userLikes = userLikes;
		this.userDislikes = userDislikes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public List<User> getUserLikes() {
		return userLikes;
	}

	public void setUserLikes(List<User> userLikes) {
		this.userLikes = userLikes;
	}

	public List<User> getUserDislikes() {
		return userDislikes;
	}

	public void setUserDislikes(List<User> userDislikes) {
		this.userDislikes = userDislikes;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", suggestion=" + suggestion + ", userLikes=" + userLikes + ", userDislikes="
				+ userDislikes + "]";
	}
	
}

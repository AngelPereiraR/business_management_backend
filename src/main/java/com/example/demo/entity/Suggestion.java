package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Suggestion {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String commentary;
	
	private String state;
	
	private String username;
	
	@JsonBackReference(value="userSuggestion")
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@JsonBackReference(value="suggestionsCompany")
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	
	@JsonManagedReference(value="suggestionsFavorite")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "suggestion")
	private List<Favorite> favorite;

	public Suggestion() {
		super();
	}

	public Suggestion(long id, String commentary, String state, String username, User user, Company company, List<Favorite> favorite) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}

	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", commentary=" + commentary + ", state=" + state + ", username=" + username
				+ ", user=" + user + ", company=" + company + ", favorite=" + favorite + "]";
	}

}

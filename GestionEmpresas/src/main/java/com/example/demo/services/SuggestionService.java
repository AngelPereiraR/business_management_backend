package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Favorite;
import com.example.demo.entity.Suggestion;
import com.example.demo.model.SuggestionModel;

public interface SuggestionService {
	public abstract Suggestion addSuggestion(Suggestion suggestionModel);
	public abstract Suggestion findSuggestionById(int id);
	public abstract SuggestionModel findSuggestionModelById(int id);
	public abstract boolean removeSuggestion(int id);
	public abstract Suggestion transform(SuggestionModel suggestionModel);
	public abstract SuggestionModel transform(Suggestion suggestion);
	public abstract Suggestion updateSuggestion(Suggestion suggestionModel);
	public abstract Favorite updateFavorite(Favorite favorite);
	public abstract List<Suggestion> findSuggestions();
	public abstract List<Suggestion> listSuggestionsByCompany(int idCompany);
	public abstract List<Suggestion> listSuggestionsByUserId(int userId);
	public abstract List<Favorite> listSuggestionsFavorites();
	public abstract Favorite addFavorite(Favorite favorite);
}

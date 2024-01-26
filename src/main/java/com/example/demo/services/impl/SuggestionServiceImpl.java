package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Favorite;
import com.example.demo.entity.Suggestion;
import com.example.demo.model.SuggestionModel;
import com.example.demo.repository.FavoriteRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.services.SuggestionService;

@Service("suggestionService")
public class SuggestionServiceImpl implements SuggestionService {
	
	@Autowired
	@Qualifier("suggestionRepository")
	private SuggestionRepository suggestionRepository;
	
	@Autowired
	@Qualifier("favoriteRepository")
	private FavoriteRepository favoriteRepository;

	@Override
	public Suggestion addSuggestion(Suggestion suggestion) {
		// TODO Auto-generated method stub
		return suggestionRepository.save(suggestion);
	}

	@Override
	public Suggestion findSuggestionById(int id) {
		// TODO Auto-generated method stub
		return suggestionRepository.findById(id);
	}

	@Override
	public SuggestionModel findSuggestionModelById(int id) {
		// TODO Auto-generated method stub
		return transform(suggestionRepository.findById(id));
	}

	@Override
	public boolean removeSuggestion(int id) {
		suggestionRepository.deleteById(id);
		return false;
	}

	@Override
	public Suggestion transform(SuggestionModel suggestionModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(suggestionModel, Suggestion.class);
	}

	@Override
	public SuggestionModel transform(Suggestion suggestion) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(suggestion, SuggestionModel.class);
	}

	@Override
	public Suggestion updateSuggestion(Suggestion suggestion) {
		// TODO Auto-generated method stub
		return suggestionRepository.save(suggestion);
	}
	
	@Override
	public Favorite updateFavorite(Favorite favorite) {
		// TODO Auto-generated method stub
		return favoriteRepository.save(favorite);
	}

	@Override
	public List<Suggestion> findSuggestions() {
		List<Suggestion> suggestions = new ArrayList<Suggestion>();
		for(Suggestion s : suggestionRepository.findAll()) {
			suggestions.add(s);
		}
		return suggestions;
	}

	@Override
	public List<Suggestion> listSuggestionsByCompany(int idCompany) {
		List<Suggestion> suggestions = new ArrayList<Suggestion>();
		for(Suggestion s : suggestionRepository.findAllByCompanyId(idCompany)) {
			suggestions.add(s);
		}
		return suggestions;
	}

	@Override
	public List<Suggestion> listSuggestionsByUserId(int userId) {
		List<Suggestion> suggestions = new ArrayList<Suggestion>();
		for(Suggestion s : suggestionRepository.findAllByUserId(userId)) {
			suggestions.add(s);
		}
		return suggestions;
	}

	@Override
	public List<Favorite> listSuggestionsFavorites() {
		List<Favorite> suggestions = new ArrayList<Favorite>();
		for(Favorite s : favoriteRepository.findAll()) {
			suggestions.add(s);
		}
		return suggestions;
	}
	
	@Override
	public Favorite addFavorite(Favorite favorite) {
		// TODO Auto-generated method stub
		return favoriteRepository.save(favorite);
	}

}

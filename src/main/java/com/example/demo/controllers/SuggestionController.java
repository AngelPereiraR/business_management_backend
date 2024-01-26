package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.Favorite;
import com.example.demo.entity.Suggestion;
import com.example.demo.entity.User;
import com.example.demo.services.CompanyService;
import com.example.demo.services.SuggestionService;
import com.example.demo.services.impl.UserService;

@RestController
@RequestMapping("/api")
public class SuggestionController {
	@Autowired
	@Qualifier("suggestionService")
	private SuggestionService suggestionService;
	
	@Autowired
	@Qualifier("companyService")
	private CompanyService companyService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@DeleteMapping("/suggestions/{id}")
	public ResponseEntity<?> deleteSuggestion(@PathVariable int id) {
		boolean exist = true;
		exist = suggestionService.removeSuggestion(id);
		if (exist == false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/companies/{id}/suggestions/{username}")
	public ResponseEntity<?> insertSuggestion(@PathVariable int id, @RequestBody Suggestion suggestion, @PathVariable String username) {
		Company company = companyService.findCompanyById(id);
		User user = userService.findUser(username);
		suggestion.setCompany(company);
		suggestion.setUser(user);
		suggestionService.addSuggestion(suggestion);
		return ResponseEntity.status(HttpStatus.CREATED).body(suggestion);
	}

	@GetMapping("/suggestions")
	public ResponseEntity<?> getSuggestions() {
		List<Suggestion> suggestions = suggestionService.findSuggestions();
		if (suggestions.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(suggestions);
		}
	}
	
	@GetMapping("/companies/{id}/suggestions")
	public ResponseEntity<?> getSuggestionsByCompany(@PathVariable int id) {
		List<Suggestion> suggestions = suggestionService.listSuggestionsByCompany(id);
		if (suggestions.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(suggestions);
		}
	}

	@GetMapping("/suggestions/{id}")
	public ResponseEntity<?> getSuggestionById(@PathVariable int id) {
		Suggestion suggestion = suggestionService.findSuggestionById(id);
		if (suggestion == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(suggestion);
		}
	}

	@PutMapping("/companies/{id}/suggestions/{username}/{idSuggestion}")
	public ResponseEntity<?> updateSuggestionById(@PathVariable int id, @PathVariable int idSuggestion, @RequestBody Suggestion suggestion, @PathVariable String username) {
		Company company = companyService.findCompanyById(id);
		User user = userService.findUser(username);
		suggestion.setCompany(company);
		suggestion.setUser(user);
		return ResponseEntity.ok(suggestionService.updateSuggestion(suggestion));
	}
	
	@PutMapping("/suggestions/{id}/accept")
	public ResponseEntity<?> updateSuggestionAccept(@PathVariable int id) {
		Suggestion suggestion = suggestionService.findSuggestionById(id);
		suggestion.setState("Accepted");
		return ResponseEntity.ok(suggestionService.updateSuggestion(suggestion));
	}
	
	@PutMapping("/suggestions/{id}/denegate")
	public ResponseEntity<?> updateSuggestionDenegate(@PathVariable int id) {
		Suggestion suggestion = suggestionService.findSuggestionById(id);
		suggestion.setState("Denegated");
		return ResponseEntity.ok(suggestionService.updateSuggestion(suggestion));
	}
	
	@PutMapping("/suggestions/{id}/like/{username}")
	public ResponseEntity<?> updateSuggestionLike(@PathVariable int id, @PathVariable String username) {
		Suggestion suggestion = suggestionService.findSuggestionById(id);
		User user = userService.findUser(username);
		List<User> users = new ArrayList<User>();
		users.add(user);
		List<Favorite> favorites = suggestionService.listSuggestionsFavorites();
		int index = -1;
		
		for(int i = 0; i < favorites.size(); i++) {
			if(favorites.get(i).getSuggestion().equals(suggestion)) {
				if(favorites.get(i).getUserDislikes() != null) {
					for(int j = 0; j < favorites.get(i).getUserDislikes().size(); j++) {
						if(favorites.get(i).getUserDislikes().get(j).equals(user)) {
							favorites.get(i).getUserDislikes().remove(j);
						}
					}
				}
				
				if(favorites.get(i).getUserLikes() == null) {
					favorites.get(i).setUserLikes(users);
				} else {
					favorites.get(i).getUserLikes().add(user);
					favorites.get(i).setUserLikes(favorites.get(i).getUserLikes());
				}
				
				index = i;
			}
		}
		
		if(index != -1) {
			return ResponseEntity.ok(suggestionService.updateFavorite(favorites.get(index)));
		} else {
			return ResponseEntity.ok(suggestionService.addFavorite(new Favorite(0, suggestion, users, null)));
		}
	}
	
	@PutMapping("/suggestions/{id}/dislike/{username}")
	public ResponseEntity<?> updateSuggestionDislike(@PathVariable int id, @PathVariable String username) {
		Suggestion suggestion = suggestionService.findSuggestionById(id);
		User user = userService.findUser(username);
		List<User> users = new ArrayList<User>();
		users.add(user);
		List<Favorite> favorites = suggestionService.listSuggestionsFavorites();
		int index = -1;

		for(int i = 0; i < favorites.size(); i++) {
			if(favorites.get(i).getSuggestion().equals(suggestion)) {
				if(favorites.get(i).getUserLikes() != null) {
					for(int j = 0; j < favorites.get(i).getUserLikes().size(); j++) {
						if(favorites.get(i).getUserLikes().get(j).equals(user)) {
							favorites.get(i).getUserLikes().remove(j);
						}
					}
				}
				
				if(favorites.get(i).getUserDislikes() == null) {
					favorites.get(i).setUserDislikes(users);
				} else {
					favorites.get(i).getUserDislikes().add(user);
					favorites.get(i).setUserDislikes(favorites.get(i).getUserDislikes());
				}
				
				index = i;
			}
		}
		
		if(index != -1) {
			return ResponseEntity.ok(suggestionService.updateFavorite(favorites.get(index)));
		} else {
			return ResponseEntity.ok(suggestionService.addFavorite(new Favorite(0, suggestion, null, users)));
		}
	}
	
	@GetMapping("/suggestions/favorite")
	public ResponseEntity<?> getSuggestionFavorites() {
		List<Favorite> favorites = suggestionService.listSuggestionsFavorites();
		if (favorites == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(favorites);
		}
	}
}

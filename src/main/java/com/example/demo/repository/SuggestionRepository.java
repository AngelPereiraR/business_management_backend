package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Suggestion;

@Repository("suggestionRepository")
public interface SuggestionRepository extends JpaRepository<Suggestion, Serializable>{
	public abstract Suggestion findById(int id);
	public abstract List<Suggestion> findAllByCompanyId(int companyId);
	public abstract List<Suggestion> findAllByUserId(int userId);
}

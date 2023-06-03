package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Serializable>{
	public abstract Category findById(int id);
}

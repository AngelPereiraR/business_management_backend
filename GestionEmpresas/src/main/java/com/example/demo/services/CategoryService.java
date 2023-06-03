package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Category;
import com.example.demo.model.CategoryModel;

public interface CategoryService {
	public abstract Category addCategory(Category category);
	public abstract Category findCategoryById(int id);
	public abstract CategoryModel findCategoryModelById(int id);
	public abstract boolean removeCategory(int id);
	public abstract boolean removeProductsAndCategory(int categoryId);
	public abstract Category transform(CategoryModel categoryModel);
	public abstract CategoryModel transform(Category category);
	public abstract Category updateCategory(Category category);
	public abstract List<Category> findCategories();
}

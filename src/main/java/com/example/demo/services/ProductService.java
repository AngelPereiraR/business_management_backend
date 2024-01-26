package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;

public interface ProductService {
	public abstract Product addProduct(Product product);
	public abstract Product findProductById(int id);
	public abstract ProductModel findProductByIdModel(int id);
	public abstract boolean removeProduct(int id);
	public abstract boolean removeProductsOfCategory(int categoryId);
	public abstract Product transform(ProductModel productModel);
	public abstract ProductModel transform(Product product);
	public abstract Product updateProduct(Product product);
	public abstract List<Product> listProductsByCategory(int idCategory);
	public abstract List<Product> listProductsByCompany(int idCompany);
	public abstract List<Product> listProducts();
}

package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FavoriteRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;

import jakarta.transaction.Transactional;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository categoryRepository;

	@Autowired
	@Qualifier("favoriteRepository")
	private FavoriteRepository favoriteRepository;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public ProductModel findProductByIdModel(int id) {
		// TODO Auto-generated method stub
		return transform(productRepository.findById(id));
	}

	@Override
	public List<Product> listProductsByCategory(int categoryId) {

		List<Product> products = new ArrayList<Product>();
		for (Product product : productRepository.findAllByCategoryId(categoryId))
			products.add(product);
		return products;
	}

	@Override
	public boolean removeProduct(int id) {
		productRepository.deleteById(id);
		return false;
	}

	@Transactional
	@Override
	public boolean removeProductsOfCategory(int categoryId) {
		Category category = categoryRepository.findById(categoryId);
		productRepository.deleteAllByCategory(category);
		return false;
	}

	@Override
	public Product transform(ProductModel productModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(productModel, Product.class);
	}

	@Override
	public ProductModel transform(Product category) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(category, ProductModel.class);
	}

	@Override
	public List<Product> listProducts() {
		List<Product> productsModel = new ArrayList<Product>();
		for (Product p : productRepository.findAll()) {
			productsModel.add(p);
		}
		return productsModel;
	}
	
	@Override
	public List<Product> listProductsByCompany(int companyId) {

		List<Product> products = new ArrayList<Product>();
		for (Product product : productRepository.findAllByCompanyId(companyId))
			products.add(product);
		return products;
	}

}

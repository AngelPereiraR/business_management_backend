package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Product;
import com.example.demo.services.CompanyService;
import com.example.demo.services.OrderProductService;
import com.example.demo.services.ProductService;
import com.example.demo.services.impl.UserService;

@RestController
@RequestMapping("/api")
public class OrderProductController {
	@Autowired
	@Qualifier("orderProductService")
	private OrderProductService orderProductService;
	
	@Autowired
	@Qualifier("companyService")
	private CompanyService companyService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	@PostMapping("/orders/{companyId}/{username}/{finalPrice}")
	public ResponseEntity<?> insertOrderProduct(@PathVariable int companyId, @PathVariable String username, @PathVariable double finalPrice) {
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setCompanyName(companyService.findCompanyById(companyId).getName());
		orderProduct.setUserUsername(username);
		orderProduct.setFinalPrice(finalPrice);
		orderProduct.setCompany(companyService.findCompanyById(companyId));
		orderProduct.setUser(userService.findUser(username));
		orderProductService.addOrderProduct(orderProduct);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderProduct);
	}

	@GetMapping("/orders")
	public ResponseEntity<?> getOrderProducts() {
		List<OrderProduct> orderProducts = orderProductService.findOrderProducts();
		if (orderProducts.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(orderProducts);
		}
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<?> getOrderProduct(@PathVariable int id) {
		OrderProduct orderProduct = orderProductService.findOrderProductById(id);
		return ResponseEntity.ok(orderProduct);
	}
	
	@PutMapping("/orders/{orderId}/product/{productId}/{quantity}")
	public ResponseEntity<?> insertProductIntoOrderProduct(@PathVariable int orderId, @PathVariable int productId, @PathVariable String quantity) {
		OrderProduct orderProduct = orderProductService.findOrderProductById(orderId);
		List<Product> products = orderProduct.getProducts();
		List<String> quantities = orderProduct.getQuantities();
		if(products == null) {
			products = new ArrayList<Product>();
			Product product = productService.findProductById(productId);
			product.getOrders().add(orderProduct);
			product.setOrders(product.getOrders());
			productService.updateProduct(product);
			products.add(product);
			orderProduct.setProducts(products);
		} else {
			Product product = productService.findProductById(productId);
			product.getOrders().add(orderProduct);
			product.setOrders(product.getOrders());
			productService.updateProduct(product);
			products.add(product);
			orderProduct.setProducts(products);
		}
		
		if(quantities == null) {
			quantities = new ArrayList<String>();
			quantities.add(quantity);
			orderProduct.setQuantities(quantities);
		} else {
			quantities.add(quantity);
			orderProduct.setQuantities(quantities);
		}
		
		orderProductService.updateOrderProduct(orderProduct);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderProduct);
	}

}

package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderProduct;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.services.OrderProductService;

@Service("orderProductService")
public class OrderProductServiceImpl implements OrderProductService {
	@Autowired
	@Qualifier("orderProductRepository")
	private OrderProductRepository orderProductRepository;

	@Override
	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		// TODO Auto-generated method stub
		return orderProductRepository.save(orderProduct);
	}

	@Override
	public List<OrderProduct> findOrderProducts() {
		List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		for(OrderProduct c : orderProductRepository.findAll()) {
			orderProducts.add(c);
		}
		return orderProducts;
	}

	@Override
	public OrderProduct findOrderProductById(int orderId) {
		// TODO Auto-generated method stub
		return orderProductRepository.findById(orderId);
	}
	
	@Override
	public OrderProduct updateOrderProduct(OrderProduct orderProduct) {
		// TODO Auto-generated method stub
		return orderProductRepository.save(orderProduct);
	}
}

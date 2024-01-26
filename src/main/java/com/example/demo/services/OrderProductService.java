package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.OrderProduct;

public interface OrderProductService {
	public abstract OrderProduct addOrderProduct(OrderProduct orderProduct);
	public abstract List<OrderProduct> findOrderProducts();
	public abstract OrderProduct findOrderProductById(int orderId);
	public abstract OrderProduct updateOrderProduct(OrderProduct orderProduct);
}

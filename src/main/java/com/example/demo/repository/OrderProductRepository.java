package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderProduct;

@Repository("orderProductRepository")
public interface OrderProductRepository extends JpaRepository<OrderProduct, Serializable>{
	public abstract OrderProduct findById(int id);
}

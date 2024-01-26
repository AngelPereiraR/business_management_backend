package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.User;

@Repository("companyRepository")
public interface CompanyRepository extends JpaRepository<Company, Serializable>{
	public abstract Company findById(int id);
	public abstract Company findByUser(User user);
}

package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Company;
import com.example.demo.entity.User;
import com.example.demo.model.CompanyModel;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	@Qualifier("companyRepository")
	private CompanyRepository companyRepository;
	
	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository categoryRepository;
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public Company addCompany(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		return companyRepository.save(transform(companyModel));
	}

	@Override
	public Company findCompanyById(int id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id);
	}

	@Override
	public CompanyModel findCompanyModelById(int id) {
		// TODO Auto-generated method stub
		return transform(companyRepository.findById(id));
	}

	@Override
	public boolean removeCompany(int id) {
		companyRepository.deleteById(id);
		return false;
	}

	@Override
	public Company transform(CompanyModel companyModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(companyModel, Company.class);
	}

	@Override
	public CompanyModel transform(Company company) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(company, CompanyModel.class);
	}

	@Override
	public Company updateCompany(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		return companyRepository.save(transform(companyModel));
	}

	@Override
	public List<Company> findCompanies() {
		List<Company> companies = new ArrayList<Company>();
		for(Company c : companyRepository.findAll()) {
			companies.add(c);
		}
		return companies;
	}
	
	@Override
	public Company findCompanyByUser(String username) {
		User user = userService.findUser(username);
		Company company = companyRepository.findByUser(user);
		return company;
	}

}

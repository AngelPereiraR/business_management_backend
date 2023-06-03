package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Company;
import com.example.demo.model.CompanyModel;

public interface CompanyService {
	public abstract Company addCompany(CompanyModel companyModel);
	public abstract Company findCompanyById(int id);
	public abstract CompanyModel findCompanyModelById(int id);
	public abstract boolean removeCompany(int id);
	public abstract Company transform(CompanyModel companyModel);
	public abstract CompanyModel transform(Company company);
	public abstract Company updateCompany(CompanyModel companyModel);
	public abstract List<Company> findCompanies();
	public abstract Company findCompanyByUser(String user);
}

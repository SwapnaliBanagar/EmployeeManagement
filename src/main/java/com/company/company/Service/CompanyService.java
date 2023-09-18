package com.company.company.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.company.Dto.CompanyDto;
import com.company.company.Entity.CompanyEntity;

@Service
public interface CompanyService {
	public Map<String,String> doregistration( CompanyDto companyDto);
	public String dologin(String id, String password);
	public CompanyDto dogetId( int id);
	public CompanyDto doUpdateId(  CompanyDto companyDto , int id);
	public String doDelete( int id);
	public List<CompanyDto>dogetallemployeeDetails();
	public List<CompanyEntity> getpaginationAndShorting( int pageNo, int pageSize,String field );
	


}

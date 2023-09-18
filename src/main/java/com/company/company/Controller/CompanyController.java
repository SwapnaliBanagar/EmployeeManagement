package com.company.company.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.company.Dto.CompanyDto;
import com.company.company.Entity.CompanyEntity;
import com.company.company.Service.CompanyService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {
	@Autowired
	CompanyService companyService;

	@PostMapping("/employeeRegistration")
	public Map<String, String> doregistration(@RequestBody CompanyDto companyDto) {
		Map<String, String> firstName = companyService.doregistration(companyDto);
		return firstName;

	}

	@GetMapping("/allemployeeDetails")
	public List<CompanyDto> dogetallemployeeDetails() {
		List<CompanyDto> employeeDetails = companyService.dogetallemployeeDetails();
		return employeeDetails;

	}

	@GetMapping("/login/{id}/{password}")
	public String dologin(@PathVariable String id, @PathVariable String password) {
		String password1 = companyService.dologin(id, password);
		return password1;

	}

	@GetMapping("/employee/{id}")
	public CompanyDto dogetId(@PathVariable int id) {
		CompanyDto id1 = companyService.dogetId(id);
		return id1;

	}

	@PutMapping("/updateEmployee/{id}")
	public CompanyDto doUpdateId(@RequestBody CompanyDto companyDto, @PathVariable int id) {
		CompanyDto companyDtoList = companyService.doUpdateId(companyDto, id);

		return companyDtoList;

	}

	@DeleteMapping("/{id}")
	public String doDelete(@PathVariable int id) {
		String Delete=companyService.doDelete(id);
		return " Delete Data Successfully Id Number =" +id;

	}
	@GetMapping("/company/{pageNo}/{pageSize}/{field}")
	public List<CompanyEntity>getpaginationAndShorting(@PathVariable int pageNo, @PathVariable int pageSize ,@PathVariable String field)
	{
		List<CompanyEntity> pageResul=companyService.getpaginationAndShorting(pageNo, pageSize,field);
		return pageResul;
		
	}
	

}

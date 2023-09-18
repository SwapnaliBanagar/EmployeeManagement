package com.company.company.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.company.company.Dto.CompanyDto;
import com.company.company.Entity.CompanyEntity;
import com.company.company.Repository.CompanyRepository;
import com.company.company.Repository.PaginationRepository;
import com.company.company.Service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	PaginationRepository paginationRepository;

	@Override
	public Map<String, String> doregistration(CompanyDto companyDto) {

		Map<String, String> hashMap = new HashMap<>();
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setId(companyDto.getId());
		companyEntity.setEmployeeId(companyDto.getEmployeeId());
		companyEntity.setFirstName(companyDto.getFirstName());
		companyEntity.setmiddleName(companyDto.getmiddleName());
		companyEntity.setLastName(companyDto.getLastName());
		companyEntity.setPassword(companyDto.getPassword());
		companyRepository.save(companyEntity);

		String message = "Your registration has been done successufully!";
		hashMap.put("Message", message);
		hashMap.put("Id", String.valueOf(companyDto.getId()));
		hashMap.put("Password", companyDto.getPassword());
		return hashMap;
	}

	@Override
	public String dologin(String id, String password) {
		List<CompanyEntity> companyEntity = (List<CompanyEntity>) companyRepository.findAll();
		for (int i = 0; i < companyEntity.size(); i++) {
			if (companyEntity.get(i).getId() == Integer.parseInt(id)
					&& companyEntity.get(i).getPassword().equals(password)) {
				return "Login Successfully";
			}

		}

		return "Login Failed........Enter Valid Id and Password..";

	}

	@Override
	public CompanyDto dogetId(int id) {
		Optional<CompanyEntity> companyEntity = companyRepository.findById(id);
		List<CompanyDto> companyDtoList = new ArrayList<>();
		CompanyDto companyDto = null;

		companyDto = new CompanyDto();
		companyDto.setId(companyEntity.get().getId());
		companyDto.setEmployeeId(companyEntity.get().getEmployeeId());
		companyDto.setFirstName(companyEntity.get().getFirstName());
		companyDto.setmiddleName(companyEntity.get().getmiddleName());
		companyDto.setLastName(companyEntity.get().getLastName());
		companyDto.setPassword(companyEntity.get().getPassword());
		companyDtoList.add(companyDto);

		return companyDto;
	}

	@Override
	public CompanyDto doUpdateId(CompanyDto companyDto, int id) {

		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setId(companyDto.getId());
		companyEntity.setEmployeeId(companyDto.getEmployeeId());
		companyEntity.setFirstName(companyDto.getFirstName());
		companyEntity.setmiddleName(companyDto.getmiddleName());
		companyEntity.setLastName(companyDto.getLastName());
		companyEntity.setPassword(companyDto.getPassword());
		companyRepository.save(companyEntity);
		return companyDto;
	}

	@Override
	public String doDelete(int id) {
		companyRepository.deleteById(id);

		return "Delete data";

	}

	@Override
	public List<CompanyDto> dogetallemployeeDetails() {

		List<CompanyEntity> companyEntity = (List<CompanyEntity>) companyRepository.findAll();
		List<CompanyDto> companyDtoList = new ArrayList<>();
		CompanyDto companyDto = null;
		for (int i = 0; i < companyEntity.size(); i++) {
			companyDto = new CompanyDto();
			companyDto.setId(companyEntity.get(i).getId());
			companyDto.setEmployeeId(companyEntity.get(i).getEmployeeId());
			companyDto.setFirstName(companyEntity.get(i).getFirstName());
			companyDto.setmiddleName(companyEntity.get(i).getmiddleName());
			companyDto.setLastName(companyEntity.get(i).getLastName());
			companyDto.setPassword(companyEntity.get(i).getPassword());
			companyDtoList.add(companyDto);

		}
		return companyDtoList;
	}

	public List<CompanyEntity> getpaginationAndShorting(int pageNo, int pageSize,String field) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Direction.ASC, field));
		Page<CompanyEntity> page = paginationRepository.findAll(paging);
		return page.toList();
	}

	
	}


	
	
	


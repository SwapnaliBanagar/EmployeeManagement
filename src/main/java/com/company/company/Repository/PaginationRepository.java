package com.company.company.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.company.company.Entity.CompanyEntity;
@Repository
public interface PaginationRepository extends PagingAndSortingRepository<CompanyEntity, Integer> {

	

	//void findAll(Pageable paging);

	

}

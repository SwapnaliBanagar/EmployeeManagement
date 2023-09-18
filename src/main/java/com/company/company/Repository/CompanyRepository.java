package com.company.company.Repository;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.company.Entity.CompanyEntity;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer>{
	
	
	
	
}	
	
	/*
	 * @Query(value="select pageNo,recordCount where CompanyEntity  " )
	 * Optional<CompanyEntity> findAll(PageRequest pageable);
	 */
	
	
	
	

//	@Query(Value="select pageNo,recordCount from CompanyEntity where  "  )
	//List<CompanyEntity> findAll(List<Order> list);

	//@Query(value = "select name,author,price from Book b where b.price>?1 and b.price<?2")
	
		//List<Book> findByPriceRange(long price1, long price2);

	
	


package com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Product;
import com.entity.Users;

public interface ProductsRepo extends JpaRepository<Product, Long>{
	
	@Query(value = "SELECT a FROM Product a WHERE a.material=?1 ")
	 List<Product> findBymaterial(String material);
	
	@Query(value = "SELECT a FROM Product a WHERE a.brand=?1 ")
	 List<Product> findBybrand(String brand);
	
	@Query(value = "SELECT a FROM Product a WHERE a.material=?1 AND a.id=?2 ")
	Optional<Product>findmaterial(String material,long id);
	

}

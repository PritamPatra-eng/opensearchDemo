package com.practice.opensearchdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.opensearchdemo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByProductNameContaining(String name);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByPriceBetween(Double startPrice, Double endPrice);
	
	List<Product> findByCategoryAndPriceBetween(String category, Double startPrice, Double endPrice);
	
	@Query("SELECT p FROM Product p WHERE p.availableStock > 0")
	List<Product> findByAvailabilityTrue();
	
	List<Product> findByManufacturer(String manufacturer);
	
	@Query("SELECT p FROM Product p WHERE " +
	       "LOWER(p.productName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
	       "LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
	       "LOWER(p.category) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
	       "LOWER(p.manufacturer) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
	List<Product> findBySerchTerm(String searchTerm);
	
}

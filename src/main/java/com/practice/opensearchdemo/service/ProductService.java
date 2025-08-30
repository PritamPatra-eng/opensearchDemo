package com.practice.opensearchdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.opensearchdemo.dto.ProductSaveRequest;
import com.practice.opensearchdemo.entity.Product;
import com.practice.opensearchdemo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(ProductSaveRequest product) {
		Product newProduct = Product.builder()
				.productName(product.getProductName())
				.description(product.getDescription())
				.price(product.getPrice())
				.category(product.getCategory())
				.manufacturer(product.getManufacturer())
				.availableStock(product.getAvailableStock())
				.imageUrl(product.getImageUrl())
				.rating(product.getRating())
				.build();
		// newProduct.setProductName(product.getProductName());
		// newProduct.setDescription(product.getDescription());
		// newProduct.setPrice(product.getPrice());
		// newProduct.setCategory(product.getCategory());
		// newProduct.setManufacturer(product.getManufacturer());
		// newProduct.setAvailableStock(product.getAvailableStock());
		// newProduct.setImageUrl(product.getImageUrl());
		// newProduct.setRating(product.getRating());
		Product saved = productRepository.save(newProduct);
		return saved;
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public List<Product> searchProduct(String searchTerm) {
		return productRepository.findBySerchTerm(searchTerm);
	}
	
	public void deleteProduct(long productId) {
		productRepository.deleteById(productId);
	}
	
	public List<Product> getProductsByPriceRange(String startPrice, String endPrice) {
		return productRepository.findByPriceBetween(Double.valueOf(startPrice), Double.valueOf(endPrice));
	}
}

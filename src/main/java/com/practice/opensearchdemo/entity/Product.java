package com.practice.opensearchdemo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
	@SequenceGenerator(name = "product_seq_generator", sequenceName = "product_seq", allocationSize = 1)
	private long productId;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "manufacturer", nullable = false)
	private String manufacturer;
	
	@Column(name = "available_stock", nullable = false)
	private int availableStock;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "rating")
	private Double rating;
	
	@Column(name = "created_at", nullable = false)
	private Timestamp createdAt;
	
	@PrePersist
	protected void onUpdate() {
		createdAt = new Timestamp(System.currentTimeMillis());
	}
}
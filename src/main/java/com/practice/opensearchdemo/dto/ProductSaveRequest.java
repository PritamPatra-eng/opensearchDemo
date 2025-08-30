package com.practice.opensearchdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveRequest {
    private String productName;
    private String description;
    private Double price;
    private String category;
    private String manufacturer;
    private int availableStock;
    private String imageUrl;
    private Double rating;
}

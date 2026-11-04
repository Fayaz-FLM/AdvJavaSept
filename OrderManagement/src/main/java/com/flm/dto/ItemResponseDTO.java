package com.flm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDTO {
	
	private long itemId;
	
	private String itemName;
	
	private String category;
	
	private double price;
	
	private String brand;
	
	private int quantity;
	
	private int discount;
	
	private double rating;

}

package com.flm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemResponseDTO {
	
	private long orderItemId;
	
	private long itemId;
	
	private String itemName;
	
	private double orderItemPrice;
	
	private double orderItemQuantity;
	
	private int discount;
	
}

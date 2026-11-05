package com.flm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewOrderItemRequestDTO {
	
	private long itemId;
	
	private double orderItemPrice;
	
	private double orderItemQuantity;
	
	private int discount;

}

package com.flm.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewOrderRequestDTO {
	
	private String name;
	
	private int numberOfItems;
	
	private double totalPrice;
	
	private List<NewOrderItemRequestDTO> orderItemsRequestDTOs;
}

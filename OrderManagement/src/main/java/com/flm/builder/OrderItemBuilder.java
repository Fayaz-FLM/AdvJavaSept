package com.flm.builder;

import com.flm.dto.NewOrderItemRequestDTO;
import com.flm.dto.OrderItemResponseDTO;
import com.flm.model.OrderItem;

public class OrderItemBuilder {
	
	public static OrderItem buildOrderItemFromOrderItemRequestDTO(NewOrderItemRequestDTO orderItemRequestDTO) {
		
		return OrderItem.builder()
			.orderItemPrice(orderItemRequestDTO.getOrderItemPrice())
			.orderItemQuantity(orderItemRequestDTO.getOrderItemQuantity())
			.discount(orderItemRequestDTO.getDiscount())
			.build();
	}
	
	public static OrderItemResponseDTO buildOrderItemResponseDTOFromOrderItem(OrderItem orderItem) {
		
		return OrderItemResponseDTO.builder()
			.orderItemId(orderItem.getOrderItemId())
			.itemId(orderItem.getItem().getItemId())
			.discount(orderItem.getDiscount())
			.orderItemPrice(orderItem.getOrderItemPrice())
			.orderItemQuantity(orderItem.getOrderItemQuantity())
			.orderItemId(orderItem.getItem().getItemId())
			.itemName(orderItem.getItem().getItemName())
			.build();
	}

}

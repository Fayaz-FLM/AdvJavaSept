package com.flm.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flm.dto.NewOrderItemRequestDTO;
import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderItemResponseDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.dto.OrderStatus;
import com.flm.model.Order;
import com.flm.model.OrderItem;

public class OrderBuilder {
	
	public static Order buildOrderFromOrderRequestDTO(NewOrderRequestDTO orderRequestDTO) {
		
		List<NewOrderItemRequestDTO> orderItemsRequestDTOs = orderRequestDTO.getOrderItemsRequestDTOs();
		
		List<OrderItem> orderItemsList = new ArrayList<OrderItem>();
		
		for(NewOrderItemRequestDTO orderItemRequestDTO : orderItemsRequestDTOs) {
			
			OrderItem orderItem = OrderItemBuilder.buildOrderItemFromOrderItemRequestDTO(orderItemRequestDTO);
			orderItemsList.add(orderItem);
		}
		
		
		return Order.builder()
			.name(orderRequestDTO.getName())
			.numberOfItems(orderRequestDTO.getNumberOfItems())
			.totalPrice(orderRequestDTO.getTotalPrice())
			.dateOfOrder(LocalDate.now())
			.orderStatus(OrderStatus.PLACED)
			.orderItems(orderItemsList)
			.build();
	}
	
	
	
	public static OrderResponseDTO buildOrderResponseDTOFromOrder(Order order) {
		
		List<OrderItem> orderItems = order.getOrderItems();
		
		List<OrderItemResponseDTO> orderItemsResponseDTOList = new ArrayList<OrderItemResponseDTO>();
		
		for(OrderItem orderItem : orderItems) {
			
			 OrderItemResponseDTO orderItemResponseDTO = OrderItemBuilder.buildOrderItemResponseDTOFromOrderItem(orderItem);
			
			 orderItemsResponseDTOList.add(orderItemResponseDTO);
		}
		
		
		return OrderResponseDTO.builder()
			.orderId(order.getOrderId())
			.numberOfItems(order.getNumberOfItems())
			.totalPrice(order.getTotalPrice())
			.dateOfOrder(order.getDateOfOrder())
			.orderStatus(order.getOrderStatus())
			.name(order.getName())
			.orderItemResponseDTOs(orderItemsResponseDTOList)
			.build();
			
	}
	
}

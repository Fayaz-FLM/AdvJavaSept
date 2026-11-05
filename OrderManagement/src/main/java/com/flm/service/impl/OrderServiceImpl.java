package com.flm.service.impl;

import com.flm.dao.ItemRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.OrderBuilder;
import com.flm.dao.OrderRepository;
import com.flm.dto.NewOrderItemRequestDTO;
import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.model.Item;
import com.flm.model.Order;
import com.flm.model.OrderItem;
import com.flm.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	private final ItemRepository itemRepository;
	@Autowired
	OrderRepository orderRepository;

	OrderServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public OrderResponseDTO placeOrder(NewOrderRequestDTO newOrderRequestDTO) {
		
		Order order = OrderBuilder.buildOrderFromOrderRequestDTO(newOrderRequestDTO);
		
		List<NewOrderItemRequestDTO> orderItemsRequestDTOs = newOrderRequestDTO.getOrderItemsRequestDTOs();
		
		List<OrderItem> orderItems = order.getOrderItems();
		
		for(int i =0 ; i<orderItemsRequestDTOs.size() ; i++) {
			
			long itemId = orderItemsRequestDTOs.get(i).getItemId();
			
			Item item = itemRepository.findById(itemId).get();
			
			OrderItem orderItem = orderItems.get(i);
			
			orderItem.setItem(item);
			orderItem.setOrder(order);
		}
		
		Order savedOrder = orderRepository.save(order);
		
		return OrderBuilder.buildOrderResponseDTOFromOrder(savedOrder);
	}
	
	

}

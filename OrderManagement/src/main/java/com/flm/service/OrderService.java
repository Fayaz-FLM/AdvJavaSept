package com.flm.service;

import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderResponseDTO;

public interface OrderService {
	
	public OrderResponseDTO placeOrder(NewOrderRequestDTO newOrderRequestDTO);

}

package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/new")
	public OrderResponseDTO placeOrder(@RequestBody NewOrderRequestDTO orderRequestDTO) {
		return orderService.placeOrder(orderRequestDTO);
	}
}

package com.flm.model;

import java.time.LocalDate;
import java.util.List;

import com.flm.dto.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Builder
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private String name;
	
	private LocalDate dateOfOrder;
	
	private int numberOfItems;
	
	private double totalPrice;
	
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItem> orderItems;
	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", dateOfOrder=" + dateOfOrder + ", numberOfItems="
				+ numberOfItems + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + "]";
	}

	public Order(String name, LocalDate dateOfOrder, int numberOfItems, double totalPrice, OrderStatus orderStatus) {
		super();
		this.name = name;
		this.dateOfOrder = dateOfOrder;
		this.numberOfItems = numberOfItems;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}
	
}

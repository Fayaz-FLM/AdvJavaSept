package com.flm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "orderitems")
@Builder
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderItemId;
	
	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	private double orderItemPrice;
	
	private double orderItemQuantity;
	
	private int discount;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemPrice=" + orderItemPrice + ", orderItemQuantity="
				+ orderItemQuantity + ", discount=" + discount + "]";
	}

	public OrderItem(double orderItemPrice, double orderItemQuantity, int discount) {
		super();
		this.orderItemPrice = orderItemPrice;
		this.orderItemQuantity = orderItemQuantity;
		this.discount = discount;
	}
	
	
}

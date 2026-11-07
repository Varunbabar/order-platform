package com.orderplatform.order.order;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.orderplatform.order.product.Product;
import com.orderplatform.order.product.ProductRepository;

@Service
public class OrderService {

	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	
	public OrderService(
			ProductRepository productRepository,
			OrderRepository orderRepository
			) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		
	}
	public Order createOrder (String productId, int quantity) {
		if(quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be greater than zero");
		}
		
		Product product = productRepository.findById(productId)
				.orElseThrow(()-> new ProductNotFoundException("Product Not Found! "));
		
		BigDecimal totalAmount = product.getPrice()
				.multiply(BigDecimal.valueOf(quantity));
		Order order = new Order();
		order.setProductId(product.getId());
		order.setQuantity(quantity);
		order.setTotalAmount(totalAmount);
		order.setStatus(OrderStatus.CREATED);
			return orderRepository.save(order);
			
		
	}
	public java.util.List<Order> getAllOrders() {
	    return orderRepository.findAll();
	}
	
	public Order getOrderById(String id) {
	    return orderRepository.findById(id)
	        .orElseThrow(() -> new OrderNotFoundException("Order not found"));
	}

}

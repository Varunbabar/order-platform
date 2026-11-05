package com.orderplatform.order.order;

import java.math.BigDecimal;

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
	public Order createOrder (String productId, int quantity) throws IllegalArgumentException {
		if(quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be greater than zero");
		}
		
		Product product = productRepository.findById(productId)
				.orElseThrow(()-> new IllegalArgumentException("Product Not Found! "));
		
		BigDecimal totalAmount = product.getPrice()
				.multiply(BigDecimal.valueOf(quantity));
		Order order = new Order();
		order.setProductId(product.getId());
		order.setQuantity(quantity);
		order.setTotalAmount(totalAmount);
		order.setStatus("CREATED");
			return orderRepository.save(order);
			
		
	}
}

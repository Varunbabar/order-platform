package com.orderplatform.order.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orderplatform.order.order.Order;
import com.orderplatform.order.order.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	 @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Order createOrder(@RequestBody CreateOrderRequest request) {
	        return orderService.createOrder(
	                request.productId(),
	                request.quantity()
	        );
	    }
	public record CreateOrderRequest(String productId, int quantity) {
		
	
	}
	
}

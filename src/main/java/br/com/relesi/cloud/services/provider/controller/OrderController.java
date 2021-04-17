package br.com.relesi.cloud.services.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.relesi.cloud.services.provider.dto.OrderItemDTO;
import br.com.relesi.cloud.services.provider.model.Order;
import br.com.relesi.cloud.services.provider.services.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST)
	public Order placeOrder(@RequestBody List<OrderItemDTO> products) {
		return orderService.placeOrder(products);
	}

	@RequestMapping("/{id}")
	public Order getOrderToId(@PathVariable Long id) {
		return orderService.getOrderToId(id);
	}
}

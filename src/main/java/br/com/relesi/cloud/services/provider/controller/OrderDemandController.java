package br.com.relesi.cloud.services.provider.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.relesi.cloud.services.provider.dto.OrderItemDTO;
import br.com.relesi.cloud.services.provider.model.OrderDemand;
import br.com.relesi.cloud.services.provider.services.OrderDemandService;

@RestController
@RequestMapping("orderDemand")
public class OrderDemandController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderDemandController.class);

	@Autowired
	private OrderDemandService orderDemandService;

	@RequestMapping(method = RequestMethod.POST)
	public OrderDemand placeOrder(@RequestBody List<OrderItemDTO> products) {
		LOG.info("Request received");
		return orderDemandService.placeOrder(products);
	}

	@RequestMapping("/{id}")
	public OrderDemand getOrderToId(@PathVariable Long id) {
		return orderDemandService.getOrderToId(id);
	}
}

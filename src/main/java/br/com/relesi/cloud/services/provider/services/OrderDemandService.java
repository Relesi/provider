package br.com.relesi.cloud.services.provider.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relesi.cloud.services.provider.dto.OrderItemDTO;
import br.com.relesi.cloud.services.provider.model.OrderDemand;
import br.com.relesi.cloud.services.provider.model.OrderItem;
import br.com.relesi.cloud.services.provider.model.Product;
import br.com.relesi.cloud.services.provider.repository.OrderDemandRepository;
import br.com.relesi.cloud.services.provider.repository.ProductRepository;

@Service
public class OrderDemandService {
	
	
	@Autowired
	private OrderDemandRepository orderDemandRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public OrderDemand placeOrder(List<OrderItemDTO> items) {
		
		if(items == null) {
			return null;
		}
		
		List<OrderItem> orderItems = toorderItems(items);
		OrderDemand order = new OrderDemand(orderItems);
		order.setPreparation(items.size());
		return orderDemandRepository.save(order);
	}
	


	public OrderDemand getOrderToId(Long id) {
		return this.orderDemandRepository.findById(id).orElse(new OrderDemand());
	}

	private List<OrderItem> toorderItems(List<OrderItemDTO> items) {
		
		List<Long> idsProducts = items
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> productsOrder = productRepository.findByIdIn(idsProducts);
		
		List<OrderItem> orderItems = items
			.stream()
			.map(item -> {
				Product product = productsOrder
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				OrderItem orderItem = new OrderItem();
				orderItem.setProduct(product);
				orderItem.setQuantity(item.getQuantity());
				return orderItem;
			})
			.collect(Collectors.toList());
		return orderItems;
	}
}

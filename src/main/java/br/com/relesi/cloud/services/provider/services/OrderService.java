package br.com.relesi.cloud.services.provider.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relesi.cloud.services.provider.dto.OrderItemDTO;
import br.com.relesi.cloud.services.provider.model.Order;
import br.com.relesi.cloud.services.provider.model.OrderItem;
import br.com.relesi.cloud.services.provider.model.Product;
import br.com.relesi.cloud.services.provider.repository.OrderRepository;
import br.com.relesi.cloud.services.provider.repository.ProductRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public Order placeOrder(List<OrderItemDTO> items) {
		
		if(items == null) {
			return null;
		}
		
		List<OrderItem> orderItems = toorderItems(items);
		Order order = new Order(orderItems);
		order.setPreparation(items.size());
		return orderRepository.save(order);
	}
	


	public Order getOrderToId(Long id) {
		return this.orderRepository.findById(id).orElse(new Order());
	}

	private List<OrderItem> toorderItems(List<OrderItemDTO> items) {
		
		List<Long> idsProducts = items
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> productsOrder = productRepository.findByIdIn(idsProducts);
		
		List<OrderItem> orderItem = items
			.stream()
			.map(item -> {
				Product product = productsOrder
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				OrderItem orderItems = new OrderItem();
				orderItems.setProduct(product);
				orderItems.setQuantity(item.getQuantity());
				return orderItems;
			})
			.collect(Collectors.toList());
		return orderItem;
	}
}

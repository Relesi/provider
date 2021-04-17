package br.com.relesi.cloud.services.provider.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Order {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Integer preparation;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private List<OrderItem> items;

	public Order(List<OrderItem> items) {
		this.items = items;
		this.status = OrderStatus.RECEIVED;
	}

	public Order() {
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Integer getPreparation() {
		return preparation;
	}

	public void setPreparation(Integer preparation) {
		this.preparation = preparation;
	}

	

}

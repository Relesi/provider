package br.com.relesi.cloud.services.provider.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.relesi.cloud.services.provider.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}

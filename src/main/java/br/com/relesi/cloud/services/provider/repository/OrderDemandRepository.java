package br.com.relesi.cloud.services.provider.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.relesi.cloud.services.provider.model.OrderDemand;


public interface OrderDemandRepository extends CrudRepository<OrderDemand, Long>{

}

package br.com.relesi.cloud.services.provider.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.relesi.cloud.services.provider.model.OrderDemand;

@Repository
public interface OrderDemandRepository extends CrudRepository<OrderDemand, Long>{

}

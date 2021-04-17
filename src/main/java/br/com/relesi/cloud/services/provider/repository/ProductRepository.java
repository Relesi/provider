package br.com.relesi.cloud.services.provider.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.relesi.cloud.services.provider.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findByEstado(String state);
	
	List<Product> findByIdIn(List<Long> ids);
}

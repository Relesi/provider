package br.com.relesi.cloud.services.provider.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.relesi.cloud.services.provider.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByState(String state);

	List<Product> findByIdIn(List<Long> ids);
}

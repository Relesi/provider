package br.com.relesi.cloud.services.provider.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relesi.cloud.services.provider.model.Product;
import br.com.relesi.cloud.services.provider.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProductToState(String state) {
		return productRepository.findByEstado(state);
	}

}

package br.com.relesi.cloud.services.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relesi.cloud.services.provider.model.Product;
import br.com.relesi.cloud.services.provider.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/{state}")
	public List<Product> getProductToState(@PathVariable("state") String state) {
		return productService.getProductToState(state);

	}
}

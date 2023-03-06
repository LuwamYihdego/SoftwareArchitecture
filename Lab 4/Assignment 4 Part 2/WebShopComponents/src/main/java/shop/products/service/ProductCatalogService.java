package shop.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.products.domain.Product;
import shop.products.repository.ProductRepository;

@Service    // calls repo.
public class ProductCatalogService {
	@Autowired
	ProductRepository productRepository;

	public void addProduct(ProductDTO productDto) {
		Product product = ProductAdapter.getProduct(productDto);
		productRepository.save(product);
		
	}
	public ProductDTO getProduct(String productnumber) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent())
		  return ProductAdapter.getProductDTO(result.get());
		else
			return null;
	}
}

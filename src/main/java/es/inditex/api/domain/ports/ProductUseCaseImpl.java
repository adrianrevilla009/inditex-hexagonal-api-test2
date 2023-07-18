package es.inditex.api.domain.ports;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.ports.spi.ProductRepository;
import es.inditex.api.exceptions.ProductNotFoundException;

import java.time.LocalDateTime;

public class ProductUseCaseImpl implements ProductUseCase {

	private ProductRepository productRepository;


	public ProductUseCaseImpl(ProductRepository repository) {
		this.productRepository = repository;
	}

	@Override
	public ProductDto getProductByBrandProductAndDate(Long productId, Long brandId, LocalDateTime startDate) {
		ProductDto productDto = productRepository.getProductByBrandProductAndDate(productId, brandId, startDate);
		if (productDto == null) {
			throw new ProductNotFoundException();
		}
		return productDto;
	}
}

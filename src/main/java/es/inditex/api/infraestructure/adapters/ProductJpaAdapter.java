package es.inditex.api.infraestructure.adapters;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.ports.ProductUseCase;
import es.inditex.api.infraestructure.entity.Product;
import es.inditex.api.infraestructure.mappers.ProductMapper;
import es.inditex.api.infraestructure.repository.ProductJpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class ProductJpaAdapter implements ProductUseCase {

    private ProductJpaRepository productJpaRepository;
    private ProductMapper productMapper;

    public ProductJpaAdapter(ProductJpaRepository productJpaRepository,
                             ProductMapper productMapper) {
        this.productJpaRepository = productJpaRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getProductByBrandProductAndDate(Long productId, Long brandId, LocalDateTime startDate) {

        Optional<Product> product = productJpaRepository.getProductByBrandProductAndDate(productId, brandId, startDate);

        if (product.isPresent()) {
            return productMapper.productToProductDto(product.get());
        }

        return null;
    }
}

package es.inditex.api.domain.ports.api;

import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;

public interface ProductService {
    /**
     * Get a product given some entry params
     * @param productRequestDto
     * @return product data
     */
    ProductResponseDto getProductByBrandProductAndDate(ProductRequestDto productRequestDto);
}

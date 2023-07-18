package es.inditex.api.domain.service.mapper;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;

public interface ProductDtoMapper {

    /**
     * Given a productDto transforms it to a productResponseDto
     * @param productDto
     * @return ProductResponseDto
     */
    ProductResponseDto productDtoToProductResponseDto(ProductDto productDto);

    /**
     * Given a productRequestDto transforms it to a productDto
     * @param productRequestDto
     * @return ProductDto
     */
    ProductDto productRequestDtoToProductDto(ProductRequestDto productRequestDto);
}

package es.inditex.api.domain.service;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import es.inditex.api.domain.ports.api.ProductService;
import es.inditex.api.domain.ports.ProductUseCase;
import es.inditex.api.domain.service.mapper.ProductDtoMapper;

public class ProductServiceImpl implements ProductService {

    private ProductUseCase productUseCase;
    private ProductDtoMapper productDtoMapper;

    public ProductServiceImpl(ProductUseCase productUseCase,
                              ProductDtoMapper productDtoMapper) {
        this.productUseCase = productUseCase;
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public ProductResponseDto getProductByBrandProductAndDate(ProductRequestDto productRequestDto) {
        ProductDto productDto = productDtoMapper.productRequestDtoToProductDto(productRequestDto);
        ProductDto response = productUseCase.getProductByBrandProductAndDate(productDto.getProductId(),
                productDto.getBrandId(),  productDto.getStartDate());
        return response != null ? productDtoMapper.productDtoToProductResponseDto(response) : null;
    }
}

package es.inditex.api.domain.service.mapper;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;

public class ProductDtoMapperImpl implements ProductDtoMapper{
    @Override
    public ProductResponseDto productDtoToProductResponseDto(ProductDto productDto) {
        return ProductResponseDto.builder()
                .productId(productDto.getProductId())
                .brandId(productDto.getBrandId())
                .startDate(productDto.getStartDate())
                .endDate(productDto.getEndDate())
                .priceList(productDto.getPriceList())
                .price(productDto.getPrice())
                .build();
    }

    @Override
    public ProductDto productRequestDtoToProductDto(ProductRequestDto productRequestDto) {
        return ProductDto.builder()
                .productId(productRequestDto.getProductId())
                .brandId(productRequestDto.getBrandId())
                .startDate(productRequestDto.getStartDate())
                .build();
    }
}

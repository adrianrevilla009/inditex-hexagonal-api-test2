package es.inditex.api.infraestructure.mappers;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.infraestructure.entity.Product;

public class ProductMapperImpl implements ProductMapper{
    @Override
    public ProductDto productToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .productId(product.getProductId())
                .brandId(product.getBrandId())
                .startDate(product.getStartDate())
                .endDate(product.getEndDate())
                .priceList(product.getPriceList())
                .price(product.getPrice())
                .priority(product.getPriority())
                .currency(product.getCurrency())
                .build();
    }
}

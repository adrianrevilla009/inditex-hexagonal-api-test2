package es.inditex.api.infraestructure.mappers;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.infraestructure.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    /**
     * Given a product transforms it to a productDto
     * @param product
     * @return ProductDto
     */
    ProductDto productToProductDto(Product product);
}

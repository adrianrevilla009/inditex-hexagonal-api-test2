package es.inditex.api.infraestructure.mappers;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.infraestructure.entity.Product;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperImplTest {

    private ProductMapper productMapper = new ProductMapperImpl();

    @Test
    public void testProductToProductDto() {
        // given
        Product product = new Product();
        product.setProductId(1L);
        product.setBrandId(100L);
        product.setStartDate(LocalDateTime.of(2020, 1, 1, 12,0));
        product.setEndDate(LocalDateTime.of(2020, 1, 1, 12,0));
        product.setPriceList(1L);
        product.setPrice(9.99);
        product.setPriority(1);
        product.setCurrency("EUR");
        // when
        ProductDto productDto = productMapper.productToProductDto(product);
        // then
        assertEquals(product.getProductId(), productDto.getProductId());
        assertEquals(product.getBrandId(), productDto.getBrandId());
        assertEquals(product.getStartDate(), productDto.getStartDate());
        assertEquals(product.getEndDate(), productDto.getEndDate());
        assertEquals(product.getPriceList(), productDto.getPriceList());
        assertEquals(product.getPrice(), productDto.getPrice());
        assertEquals(product.getPriority(), productDto.getPriority());
        assertEquals(product.getCurrency(), productDto.getCurrency());
    }
}

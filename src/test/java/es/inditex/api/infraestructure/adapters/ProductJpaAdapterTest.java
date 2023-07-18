package es.inditex.api.infraestructure.adapters;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.infraestructure.entity.Product;
import es.inditex.api.infraestructure.mappers.ProductMapper;
import es.inditex.api.infraestructure.repository.ProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductJpaAdapterTest {

    @Mock
    private ProductJpaRepository productJpaRepository;

    @Mock
    private ProductMapper productMapper;

    private ProductJpaAdapter productJpaAdapter;

    @Test
    public void testGetProductByBrandProductAndDate() {
        // given
        MockitoAnnotations.openMocks(this);
        productJpaAdapter = new ProductJpaAdapter(productJpaRepository, productMapper);

        Long productId = 1L;
        Long brandId = 100L;
        LocalDateTime startDate = LocalDateTime.now();

        Product product = new Product();
        product.setProductId(productId);
        product.setBrandId(brandId);
        product.setStartDate(startDate);

        ProductDto productDto = new ProductDto();
        productDto.setProductId(productId);
        productDto.setBrandId(brandId);
        productDto.setStartDate(startDate);
        // when
        when(productJpaRepository.getProductByBrandProductAndDate(productId, brandId, startDate)).thenReturn(Optional.of(product));

        when(productMapper.productToProductDto(product)).thenReturn(productDto);

        ProductDto resultDto = productJpaAdapter.getProductByBrandProductAndDate(productId, brandId, startDate);
        // then
        verify(productJpaRepository).getProductByBrandProductAndDate(productId, brandId, startDate);

        verify(productMapper).productToProductDto(product);

        assertEquals(productDto, resultDto);
    }
}

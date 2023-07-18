package es.inditex.api.domain.ports;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.ports.spi.ProductRepository;
import es.inditex.api.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

public class ProductUseCaseImplTest {

    @Mock
    private ProductRepository productRepository;

    private ProductUseCaseImpl productUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        productUseCase = new ProductUseCaseImpl(productRepository);
    }

    @Test
    public void testGetProductByBrandProductAndDateReturnsData() {
        // given
        Long productId = 1L;
        Long brandId = 2L;
        LocalDateTime startDate = LocalDateTime.now();
        ProductDto expectedProductDto = new ProductDto(productId, brandId, startDate);
        // when
        Mockito.when(productRepository.getProductByBrandProductAndDate(
                        ArgumentMatchers.eq(productId),
                        ArgumentMatchers.eq(brandId),
                        ArgumentMatchers.eq(startDate)))
                .thenReturn(expectedProductDto);
        ProductDto result = productUseCase.getProductByBrandProductAndDate(productId, brandId, startDate);
        // then
        Assertions.assertEquals(expectedProductDto, result);
        Mockito.verify(productRepository).getProductByBrandProductAndDate(
                ArgumentMatchers.eq(productId),
                ArgumentMatchers.eq(brandId),
                ArgumentMatchers.eq(startDate));
    }

    @Test
    public void testGetProductByBrandProductAndDateReturnsException() {
        // given
        Long productId = 1L;
        Long brandId = 2L;
        LocalDateTime startDate = LocalDateTime.now();
        // when
        Mockito.when(productRepository.getProductByBrandProductAndDate(
                        ArgumentMatchers.eq(productId),
                        ArgumentMatchers.eq(brandId),
                        ArgumentMatchers.eq(startDate)))
                .thenReturn(null);
        // then
        Assertions.assertThrows(ProductNotFoundException.class,
                () -> productUseCase.getProductByBrandProductAndDate(productId, brandId, startDate));
        Mockito.verify(productRepository).getProductByBrandProductAndDate(
                ArgumentMatchers.eq(productId),
                ArgumentMatchers.eq(brandId),
                ArgumentMatchers.eq(startDate));
    }
}

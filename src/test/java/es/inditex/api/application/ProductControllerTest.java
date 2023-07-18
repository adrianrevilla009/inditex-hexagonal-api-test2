package es.inditex.api.application;

import es.inditex.api.application.ProductController;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.ports.api.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productController = new ProductController(productService);
    }

    @Test
    public void testGetProductByBrandProductAndDate() {
        // given
        ProductRequestDto requestDto = ProductRequestDto.builder()
                .productId(1L)
                .brandId(1L)
                .build();
        // when
        ResponseEntity response = productController.getProductByBrandProductAndDate(requestDto);
        // then
        verify(productService).getProductByBrandProductAndDate(requestDto);
    }
}

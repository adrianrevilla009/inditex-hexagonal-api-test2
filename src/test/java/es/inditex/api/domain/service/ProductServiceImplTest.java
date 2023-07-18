package es.inditex.api.domain.service;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import es.inditex.api.domain.ports.ProductUseCase;
import es.inditex.api.domain.service.mapper.ProductDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    @Mock
    private ProductUseCase productUseCase;

    @Mock
    private ProductDtoMapper productDtoMapper;

    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productUseCase, productDtoMapper);
    }

    @Test
    public void testGetProductByBrandProductAndDate() {
        // given
        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setProductId(1L);
        requestDto.setBrandId(100L);
        requestDto.setStartDate(LocalDateTime.of(2020, 1, 1, 12,0));

        ProductDto productDto = new ProductDto();
        productDto.setProductId(1L);
        productDto.setBrandId(100L);
        productDto.setStartDate(LocalDateTime.of(2020, 1, 1, 12,0));

        ProductDto responseDto = new ProductDto();
        responseDto.setProductId(1L);
        responseDto.setBrandId(100L);
        responseDto.setStartDate(LocalDateTime.of(2020, 1, 1, 12,0));
        responseDto.setEndDate(LocalDateTime.of(2020, 1, 1, 12,0));
        responseDto.setPriceList(1L);
        responseDto.setPrice(9.99);
        // when
        when(productDtoMapper.productRequestDtoToProductDto(requestDto)).thenReturn(productDto);
        when(productDtoMapper.productDtoToProductResponseDto(responseDto)).thenReturn(new ProductResponseDto());

        when(productUseCase.getProductByBrandProductAndDate(1L, 100L, LocalDateTime.of(2020, 1, 1, 12,0))).thenReturn(responseDto);

        ProductResponseDto response = productService.getProductByBrandProductAndDate(requestDto);
        // then
        verify(productDtoMapper).productRequestDtoToProductDto(requestDto);
        verify(productUseCase).getProductByBrandProductAndDate(1L, 100L, LocalDateTime.of(2020, 1, 1, 12,0));
        verify(productDtoMapper).productDtoToProductResponseDto(responseDto);

        assertEquals(new ProductResponseDto(), response);
    }
}

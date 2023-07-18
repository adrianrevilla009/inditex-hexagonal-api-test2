package es.inditex.api.infraestructure.adapters;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.infraestructure.entity.Product;
import es.inditex.api.infraestructure.mappers.ProductMapper;
import es.inditex.api.infraestructure.repository.ProductJpaRepository;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Description;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductJpaAdapterSpecifiedTest {
    @Mock
    private ProductJpaRepository productJpaRepository;

    @Mock
    private ProductMapper productMapper;

    private ProductJpaAdapter productJpaAdapter;

    private List<Product> dbData;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @BeforeEach
    public void setUp() {

        this.dbData = Arrays.asList(
                Product.builder().productId(35455L).brandId(1L).startDate(LocalDateTime.parse("2020-06-14-00.00.00", formatter)).build(),
                Product.builder().productId(35455L).brandId(1L).startDate(LocalDateTime.parse("2020-06-14-15.00.00", formatter)).build(),
                Product.builder().productId(35455L).brandId(1L).startDate(LocalDateTime.parse("2020-06-15-00.00.00", formatter)).build(),
                Product.builder().productId(35455L).brandId(1L).startDate(LocalDateTime.parse("2020-06-15-16.00.00", formatter)).build()
        );
    }

    @Test
    @Name("Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    @Description("Test next values: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void testGetProductByBrandProductAndDate1() {
        // given
        MockitoAnnotations.openMocks(this);
        productJpaAdapter = new ProductJpaAdapter(productJpaRepository, productMapper);

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime startDate = LocalDateTime.parse("2020-06-14-10.00.00", formatter);
        // when
        when(productJpaRepository.getProductByBrandProductAndDate(productId, brandId, startDate)).thenReturn(Optional.of(dbData.get(0)));

        when(productMapper.productToProductDto(dbData.get(0))).thenReturn(getExpectedProductDto("2020-06-14T00:00:00"));

        ProductDto result = productJpaAdapter.getProductByBrandProductAndDate(productId, brandId, startDate);
        // then
        assertEquals(getExpectedProductDto("2020-06-14T00:00:00"), result);
    }

    @Test
    @Name("Petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    @Description("Test next values: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void testGetProductByBrandProductAndDate2() {
        // given
        MockitoAnnotations.openMocks(this);
        productJpaAdapter = new ProductJpaAdapter(productJpaRepository, productMapper);

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime startDate = LocalDateTime.parse("2020-06-14-16.00.00", formatter);
        // when
        when(productJpaRepository.getProductByBrandProductAndDate(productId, brandId, startDate)).thenReturn(Optional.of(dbData.get(3)));

        when(productMapper.productToProductDto(dbData.get(3))).thenReturn(getExpectedProductDto("2020-06-15T16:00:00"));

        ProductDto result = productJpaAdapter.getProductByBrandProductAndDate(productId, brandId, startDate);
        // then
        assertEquals(getExpectedProductDto("2020-06-15T16:00:00"), result);
    }

    @Test
    @Name("Petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    @Description("Test next values: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void testGetProductByBrandProductAndDate3() {
        // given
        MockitoAnnotations.openMocks(this);
        productJpaAdapter = new ProductJpaAdapter(productJpaRepository, productMapper);

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime startDate = LocalDateTime.parse("2020-06-14-21.00.00", formatter);
        // when
        when(productJpaRepository.getProductByBrandProductAndDate(productId, brandId, startDate)).thenReturn(Optional.empty());

        ProductDto result = productJpaAdapter.getProductByBrandProductAndDate(productId, brandId, startDate);
        // then
        assertEquals(null, result);
    }

    @Test
    @Name("Petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    @Description("Test next values: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    public void testGetProductByBrandProductAndDate4() {
        // given
        MockitoAnnotations.openMocks(this);
        productJpaAdapter = new ProductJpaAdapter(productJpaRepository, productMapper);

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime startDate = LocalDateTime.parse("2020-06-15-10.00.00", formatter);
        // when
        when(productJpaRepository.getProductByBrandProductAndDate(productId, brandId, startDate)).thenReturn(Optional.of(dbData.get(3)));

        when(productMapper.productToProductDto(dbData.get(3))).thenReturn(getExpectedProductDto("2020-06-15T10:00:00"));

        ProductDto result = productJpaAdapter.getProductByBrandProductAndDate(productId, brandId, startDate);
        // then
        assertEquals(getExpectedProductDto("2020-06-15T10:00:00"), result);
    }

    @Test
    @Name("Petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    @Description("Test next values: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    public void testGetProductByBrandProductAndDate5() {
        // given
        MockitoAnnotations.openMocks(this);
        productJpaAdapter = new ProductJpaAdapter(productJpaRepository, productMapper);

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime startDate = LocalDateTime.parse("2020-06-16-21.00.00", formatter);
        // when
        when(productJpaRepository.getProductByBrandProductAndDate(productId, brandId, startDate)).thenReturn(Optional.empty());

        ProductDto result = productJpaAdapter.getProductByBrandProductAndDate(productId, brandId, startDate);
        // then
        assertEquals(null, result);
    }

    private ProductDto getExpectedProductDto(String date) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(35455L);
        productDto.setBrandId(1L);
        productDto.setStartDate(LocalDateTime.parse(date));
        return productDto;
    }
}

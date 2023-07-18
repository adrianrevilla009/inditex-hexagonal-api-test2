package es.inditex.api.data;

import es.inditex.api.domain.data.Currency;
import es.inditex.api.infraestructure.entity.Product;
import es.inditex.api.infraestructure.repository.ProductJpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.mapstruct.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
@Component
public class DataInitializer {
    private Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private ProductJpaRepository productJpaRepository;

    public DataInitializer(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        logger.info("INITIALIZING H2 DB DATA");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

        Product p1 = new Product(1L, 35455L, 1L, LocalDateTime.parse("2020-06-14-00.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter) , 1L, 0, 35.50, Currency.EUR.getValue());
        Product p2 = new Product(2L, 35455L, 1L, LocalDateTime.parse("2020-06-14-15.00.00", formatter), LocalDateTime.parse("2020-06-14-18.30.00", formatter) , 2L, 1, 25.45, Currency.EUR.getValue());
        Product p3 = new Product(3L, 35455L, 1L, LocalDateTime.parse("2020-06-15-00.00.00", formatter), LocalDateTime.parse("2020-06-15-11.00.00", formatter) , 3L, 1, 30.50, Currency.EUR.getValue());
        Product p4 = new Product(4L, 35455L, 1L, LocalDateTime.parse("2020-06-15-16.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter) , 4L, 1, 38.95, Currency.EUR.getValue());


        this.productJpaRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        logger.info("INITIALIZED H2 DB DATA");
    }
}

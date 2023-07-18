package es.inditex.api.configuration;

import es.inditex.api.domain.ports.api.ProductService;
import es.inditex.api.domain.ports.ProductUseCase;
import es.inditex.api.domain.service.ProductServiceImpl;
import es.inditex.api.domain.service.mapper.ProductDtoMapper;
import es.inditex.api.domain.service.mapper.ProductDtoMapperImpl;
import es.inditex.api.infraestructure.adapters.ProductJpaAdapter;
import es.inditex.api.infraestructure.mappers.ProductMapper;
import es.inditex.api.infraestructure.mappers.ProductMapperImpl;
import es.inditex.api.infraestructure.repository.ProductJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductUseCase productPersistence(ProductJpaRepository productJpaRepository,
                                             ProductMapper productMapper){
        return new ProductJpaAdapter(productJpaRepository, productMapper);
    }

    @Bean
    public ProductService productService(ProductUseCase productUseCase,
                                         ProductDtoMapper productDtoMapper){
        return new ProductServiceImpl(productUseCase, productDtoMapper);
    }

    @Bean
    public ProductDtoMapper productDtoMapper(){
        return new ProductDtoMapperImpl();
    }

    @Bean
    public ProductMapper productMapper(){
        return new ProductMapperImpl();
    }
}

package es.inditex.api.infraestructure.repository;

import es.inditex.api.infraestructure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM Product p WHERE p.product_id = :productId AND p.brand_id = :brandId " +
            "AND p.start_date = :startDate",
            nativeQuery = true)
    Optional<Product> getProductByBrandProductAndDate(@Param("productId") Long productId,
                                             @Param("brandId") Long brandId,
                                             @Param("startDate") LocalDateTime startDate);
}

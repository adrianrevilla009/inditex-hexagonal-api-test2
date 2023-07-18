package es.inditex.api.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;

    private Long productId;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    private int priority;

    private Double price;

    private String currency;

    public ProductDto(Long productId, Long brandId, LocalDateTime startDate) {
    }
}
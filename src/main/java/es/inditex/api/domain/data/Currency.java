package es.inditex.api.domain.data;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Currency {
    EUR(1L, "EUR");

    private Long code;
    private String value;
}

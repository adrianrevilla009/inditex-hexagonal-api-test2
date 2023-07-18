package es.inditex.api.application;

import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import es.inditex.api.domain.ports.api.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get a product by its band id, product id and start date")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the product",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation=ProductResponseDto.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Error on request",
                    content = @Content
            )
    })
    @GetMapping("/byBrandProductAndDate")
    public ResponseEntity<Object> getProductByBrandProductAndDate(@RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = productService.getProductByBrandProductAndDate(productRequestDto);
        if (productResponseDto != null) {
            return ResponseEntity.ok().body(productResponseDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

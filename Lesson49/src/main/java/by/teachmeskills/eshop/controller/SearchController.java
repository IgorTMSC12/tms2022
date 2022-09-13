package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.dto.ProductDto;
import by.teachmeskills.eshop.services.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Tag(name = "search", description = "The search API")
@RestController
@RequestMapping("/search")
public class SearchController {
    private ProductServiceImpl productService;

    public SearchController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Open search result",
            description = "Search result",
            tags = {"search"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Info has been found",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Could not find info"
            )
    })
    @PostMapping
    public ResponseEntity<List<ProductDto>> getSearchPage(@RequestParam("search") String search) {
        List<ProductDto> productDto = productService.findAllProductsByRequest(search);
        if (Optional.ofNullable(productDto).isPresent()) {
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

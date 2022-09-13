package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.dto.CategoryDto;
import by.teachmeskills.eshop.services.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;

@Tag(name = "category", description = "The category API")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Open category page",
            description = "category page",
            tags = {"category"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Category has been found",
                    content = @Content(schema = @Schema(implementation = CategoryDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Category has not been found - not found"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> openCategoryPage(@Min(value = 1) @PathVariable int id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        if (Optional.ofNullable(categoryDto).isPresent()) {
            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

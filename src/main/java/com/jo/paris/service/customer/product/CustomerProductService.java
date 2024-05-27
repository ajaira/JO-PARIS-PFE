package com.jo.paris.service.customer.product;

import com.jo.paris.dto.CategoryDto;
import com.jo.paris.dto.CompleteProductDetailDto;
import com.jo.paris.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {

    List<CategoryDto> getAllCategories();

    List<ProductDto> searchProductByTitle(String title);

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductsByCategory(Long categoryId);

    CompleteProductDetailDto getCompleteProductDetailById(Long productId);
}

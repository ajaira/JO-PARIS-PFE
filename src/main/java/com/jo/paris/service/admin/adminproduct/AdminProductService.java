package com.jo.paris.service.admin.adminproduct;


import com.jo.paris.dto.ProductDto;
import com.jo.paris.dto.SecondProductDto;
import com.jo.paris.entity.Product;

import java.io.IOException;
import java.util.List;

public interface AdminProductService {

    Product addProduct(SecondProductDto secondProductDto) throws IOException;

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long productId);

    ProductDto updateProduct(Long productId, ProductDto productDto) throws IOException;

    boolean deleteProduct(Long productId);

    List<ProductDto> searchProductByTitle(String title);

}

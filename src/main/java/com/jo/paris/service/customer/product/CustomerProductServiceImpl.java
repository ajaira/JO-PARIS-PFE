package com.jo.paris.service.customer.product;

import com.jo.paris.dto.CategoryDto;
import com.jo.paris.dto.CompleteProductDetailDto;
import com.jo.paris.dto.ProductDto;
import com.jo.paris.entity.Category;
import com.jo.paris.entity.FAQ;
import com.jo.paris.entity.Product;
import com.jo.paris.entity.Reviews;
import com.jo.paris.repo.CategoryRepository;
import com.jo.paris.repo.FAQRepository;
import com.jo.paris.repo.ProductRepository;
import com.jo.paris.repo.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    private final FAQRepository faqRepository;

    private final ReviewRepository reviewRepository;


    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(Category::getCategoryDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> searchProductByTitle(String title) {
        return productRepository.findAllByNameContaining(title).stream().map(Product::getProductDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(Product::getProductDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByCategory(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream().map(Product::getProductDto).collect(Collectors.toList());
    }

    @Override
    public CompleteProductDetailDto getCompleteProductDetailById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        List<FAQ> faqList = faqRepository.findAllByProductId(productId);
        List<Reviews> reviewsList = reviewRepository.findAllByProductId(productId);
        if (optionalProduct.isPresent()) {
            CompleteProductDetailDto completeProductDetailDto = new CompleteProductDetailDto();
            completeProductDetailDto.setProductDto(optionalProduct.get().getProductDto());
            completeProductDetailDto.setFaqDtoList(faqList.stream().map(FAQ::getFAQDto).collect(Collectors.toList()));
            completeProductDetailDto.setReviewDtoList(reviewsList.stream().map(Reviews::getReviewDto).collect(Collectors.toList()));
            return completeProductDetailDto;
        }
        return null;
    }

}

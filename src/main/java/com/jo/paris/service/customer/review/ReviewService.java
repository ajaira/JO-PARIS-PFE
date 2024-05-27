package com.jo.paris.service.customer.review;


import com.jo.paris.dto.OrderedProductsResponseDto;
import com.jo.paris.dto.ReviewDto;

import java.io.IOException;

public interface ReviewService {


    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}

package com.jo.paris.service.customer.cart;

import com.jo.paris.dto.CartItemsDto;
import com.jo.paris.dto.OrderDto;
import com.jo.paris.dto.QuantityChangeProductDto;
import org.springframework.http.ResponseEntity;

public interface CartService {


    ResponseEntity<?> addProductToCart(CartItemsDto cartItemsDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto decreaseProductQuantity(QuantityChangeProductDto quantityChangeProductDto);

    OrderDto increaseProductQuantity(QuantityChangeProductDto quantityChangeProductDto);


}

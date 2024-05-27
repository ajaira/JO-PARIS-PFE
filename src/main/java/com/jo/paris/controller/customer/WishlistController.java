package com.jo.paris.controller.customer;

import com.jo.paris.dto.WishlistDto;
import com.jo.paris.service.customer.wishlist.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/wishlist")
    public ResponseEntity<?> addProductToWishlist(@RequestBody WishlistDto wishlistDto) throws IOException {
        WishlistDto postedWishlistDto = wishlistService.addProductToWishlist(wishlistDto);
        if (postedWishlistDto == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        return ResponseEntity.status(HttpStatus.CREATED).body(postedWishlistDto);
    }

    @GetMapping("/wishlist/{userId}")
    public ResponseEntity<List<WishlistDto>> getWishlistByUserId(@PathVariable Long userId) {
        List<WishlistDto> wishlistDtos = wishlistService.getWishlistByUserId(userId);
        return ResponseEntity.ok(wishlistDtos);
    }

}

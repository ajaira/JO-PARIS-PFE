package com.jo.paris.service.customer.wishlist;

import com.jo.paris.dto.WishlistDto;
import com.jo.paris.entity.Product;
import com.jo.paris.entity.User;
import com.jo.paris.entity.Wishlist;
import com.jo.paris.repo.ProductRepository;
import com.jo.paris.repo.UserRepository;
import com.jo.paris.repo.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final WishlistRepository wishlistRepository;

    @Override
    public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
        Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());
        if (optionalUser.isPresent() && optionalProduct.isPresent()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setProduct(optionalProduct.get());
            wishlist.setUser(optionalUser.get());
            Wishlist createdWishlist = wishlistRepository.save(wishlist);
            WishlistDto createdWishlistDto = new WishlistDto();
            createdWishlistDto.setId(createdWishlist.getId());
            return createdWishlistDto;
        }
        return null;
    }

    @Override
    public List<WishlistDto> getWishlistByUserId(Long userId) {
        return wishlistRepository.findAllByUser_Id(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
    }
}

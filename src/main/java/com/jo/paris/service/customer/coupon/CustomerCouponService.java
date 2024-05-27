package com.jo.paris.service.customer.coupon;

import com.jo.paris.dto.OrderDto;

public interface CustomerCouponService {

    OrderDto applyCoupon(Long userId, String code);

}

package com.jo.paris.service.customer.coupon;


import com.jo.paris.dto.OrderDto;
import com.jo.paris.entity.Coupon;
import com.jo.paris.entity.Order;
import com.jo.paris.enums.OrderStatus;
import com.jo.paris.exceptions.ValidationException;
import com.jo.paris.repo.CouponRepository;
import com.jo.paris.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CustomerCouponServiceImpl implements CustomerCouponService {

    private final CouponRepository couponRepository;

    private final OrderRepository orderRepository;

    public OrderDto applyCoupon(Long userId, String code) {
        Order order = orderRepository.findByUserIdAndStatus(userId, OrderStatus.Pending);
        Coupon coupon = couponRepository.findByCode(code).orElseThrow(() -> new ValidationException("Coupon not found."));

        if (couponIsExpired(coupon)) {
            throw new ValidationException("Coupon has expired.");
        }
        double discountAmount = ((coupon.getDiscount() / 100.0) * order.getTotalAmount());
        double netAmount = order.getTotalAmount() - discountAmount;

        order.setAmount((long) netAmount);
        order.setDiscount((long) discountAmount);
        order.setCoupon(coupon);


        orderRepository.save(order);
        return order.getOrderDto();
    }

    private boolean couponIsExpired(Coupon coupon) {
        Date currentDate = new Date();
        Date expirationDate = coupon.getExpirationDate();
        return expirationDate != null && currentDate.after(expirationDate);
    }
}

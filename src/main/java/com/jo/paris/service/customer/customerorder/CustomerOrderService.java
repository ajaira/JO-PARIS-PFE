package com.jo.paris.service.customer.customerorder;

import com.jo.paris.dto.OrderDto;
import com.jo.paris.dto.PlaceOrderDto;

import java.util.List;
import java.util.UUID;

public interface CustomerOrderService {

    OrderDto PlaceOrder(PlaceOrderDto placeOrderDto);

    List<OrderDto> getMyPlacedOrders(Long userId);

    OrderDto searchOrderByTrackingId(UUID trackingId);

}

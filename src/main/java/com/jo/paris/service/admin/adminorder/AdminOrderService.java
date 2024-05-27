package com.jo.paris.service.admin.adminorder;


import com.jo.paris.dto.AnalyticsResponse;
import com.jo.paris.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {

    List<OrderDto> getAllPlacedOrders();
    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();
}

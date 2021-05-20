package com.team.NewLearn.service.order;

import com.team.NewLearn.dto.order.OrderDTO;
import com.team.NewLearn.mapper.order.OrderMapper;

public interface OrderService {

    // 주문 요청
    void insertOrder(OrderDTO orderDTO);

}

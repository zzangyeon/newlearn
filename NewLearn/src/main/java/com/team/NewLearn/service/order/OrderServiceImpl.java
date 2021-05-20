package com.team.NewLearn.service.order;


import com.team.NewLearn.dto.order.OrderDTO;
import com.team.NewLearn.mapper.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderMapper orderMapper;


    public void insertOrder(OrderDTO orderDTO){
        orderMapper.insertOrder(orderDTO);
    }




}

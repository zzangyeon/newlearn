package com.team.NewLearn.controller.order;

import com.team.NewLearn.dto.order.OrderDTO;
import com.team.NewLearn.service.cart.CartService;

import com.team.NewLearn.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    String userId = "orange";
    private final OrderService orderService;
    private final CartService cartService;

    @GetMapping
    public String insertOrder(@ModelAttribute OrderDTO orderDTO){

        //orderId = 년월일_난수
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
        String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
        String subNum = "";

        for(int i = 1; i <= 6; i ++) {
            subNum += (int)(Math.random() * 10);
        }
        String orderId = ymd + "_" + subNum;

        orderDTO.setUserId(userId);
        orderDTO.setOrderId(orderId);
        orderService.insertOrder(orderDTO);
        cartService.deleteCartAll(userId);
        return "redirect:/";
    }
}

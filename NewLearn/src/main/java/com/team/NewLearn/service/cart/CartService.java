package com.team.NewLearn.service.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.mapper.cart.CartMapper;

import java.util.List;

public interface CartService {


    List<CartDTO> getCartList(String userId);

    void deleteCartAll(String userId);


    void deleteCart(CartDTO cartDTO);

}

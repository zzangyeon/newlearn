package com.team.NewLearn.service.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.mapper.cart.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartMapper cartMapper;

    public List<CartDTO> getCartList(String userId) {
        return cartMapper.selectCartList(userId);
    }

    public void deleteCartAll(String userId) {
        cartMapper.deleteCartAll(userId);
    }

    public void deleteCart(CartDTO cartDTO){
        cartMapper.deleteCart(cartDTO);
    }


}

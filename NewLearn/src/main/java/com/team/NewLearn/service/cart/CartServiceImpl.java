package com.team.NewLearn.service.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.dto.cart.CartList;
import com.team.NewLearn.mapper.cart.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartMapper cartMapper;

    public List<CartList> getCartList(int memberId) {
        return cartMapper.selectCartList(memberId);
    }

    public void deleteCartAll(int memberId) {
        cartMapper.deleteCartAll(memberId);
    }

    public int deleteCart(CartDTO cartDTO){
        return cartMapper.deleteCart(cartDTO);
    }


}

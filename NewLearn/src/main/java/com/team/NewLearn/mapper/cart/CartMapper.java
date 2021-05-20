package com.team.NewLearn.mapper.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    //장바구니 리스트 찾기(회원ID)
    public List<CartDTO> selectCartList(String userId);

   // 카트 전체 삭제
    public void deleteCartAll(String userId);

    //카트 부분 삭제
    public void deleteCart(CartDTO cartDTO);
}

package com.team.NewLearn.controller.cart;

import com.team.NewLearn.dto.cart.CartDTO;
import com.team.NewLearn.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private String userId = "";
    private final CartService cartService;

    @GetMapping("/list")
    public String getCartList(Model model, Authentication auth) {

        // 로그인한 정보 중 이름을 불러온다.
        this.userId = auth.getName().toString();

        List<CartDTO> cartLists = cartService.getCartList(userId);
        System.out.println(userId);
        model.addAttribute("cartLists", cartLists);
        return "/cart/cart";
    }

    @ResponseBody
    @PostMapping("/delete")
    public int deleteCart(@RequestParam String cartId, CartDTO cartDTO){
        cartDTO.setUserId(userId);
        cartDTO.setCartId(Integer.parseInt(cartId));
        cartService.deleteCart(cartDTO);
        int result = 1;
        return result;
    }
}

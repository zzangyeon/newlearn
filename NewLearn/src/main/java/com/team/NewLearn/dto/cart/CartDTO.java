package com.team.NewLearn.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("cartDTO")
public class CartDTO {

    private int cartId;
    private String userId;
    private int lectureId;

}

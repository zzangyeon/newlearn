package com.team.NewLearn.dto.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("orderDTO")
public class OrderDTO {

    private String orderId;
    private String userId;
    private int lectureId;
    private String orderDate;
    private String nameId;
    private String tel;
    private String email;
}

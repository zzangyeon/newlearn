package com.team.NewLearn.dto.community;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("communityDTO")
public class CommunityDTO {

    private int id;
    private String memberId;
    private String typeId;
    private String title;
    private String content;
    private String regDate;


}

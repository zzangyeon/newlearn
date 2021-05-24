package com.team.NewLearn.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Alias("lectureDTO")
public class LectureDTO {

    private int id;
    private int teacherId;
    private String title;
    private String content;
    private int price;
    private int buyCount;
    private String regDate;
    private String sContent;
}

package com.team.NewLearn.mapper.community;

import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommunityMapper {

    // 전체 글 조회
    List<CommunityDTO> selectBoardAll(Criteria cri);

    // 글 상세 조회
    CommunityDTO boardDetail(int id); //게시글 세부내용 보기
    // 글 작성
    int boardInsert(CommunityDTO communityDTO); //게시글 생성
    // 글 수정
    int boardUpdate(CommunityDTO CommunityDTO); //게시글 수정
    // 글 삭제
    int boardDelete(int id); //게시글 삭제

    // 작성된 총 글 수
    int getTotal(Criteria cri);


//    //동적 검색을 위한것
//    List<CommunityDTO> searchTest(Map<String, Map<String, String>> map);



}

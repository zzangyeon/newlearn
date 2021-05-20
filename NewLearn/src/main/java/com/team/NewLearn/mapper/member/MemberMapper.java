package com.team.NewLearn.mapper.member;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {


    // 관리자 : 회원 전체 조회
    List<MemberDTO> selectAllMember(Criteria cri);

    // 회원 : 로그인 해당 계정 정보 조회
    List<MemberDTO> selectMember(String email);

    //전체 글 갯수 조회
    int getTotal();
    // 회원 상세 조회
    MemberDTO selectDetailMember(int no);
    //회원 수정
    int memberUpdate(MemberDTO memberDTO);
    // 회원 삭제
    int memberDelete(int no);
    // 동적검색 테스트
    List<MemberDTO> searchTest(Map<String, Map<String, String>> map);



}

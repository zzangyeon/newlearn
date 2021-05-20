package com.team.NewLearn.controller.member;

import com.team.NewLearn.dto.member.MemberDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.dto.paging.PageDTO;
import com.team.NewLearn.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/mypage")
public class MemberController {

    private final MemberService memberService;

    // 전체 회원 리스트 조회
    @GetMapping("/select")
    public String selectAllMember(Criteria cri, Model model, Authentication auth) {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        if (auth.getName().equals("admin")) {

            log.info("::::[ controller 관리자 ]:::: 전체회원 조회  :::::::::::: ");

            memberDTOS = memberService.selectAllMember(cri);

            model.addAttribute("auth", auth);
            model.addAttribute("result", memberDTOS);
            model.addAttribute("pageMaker", new PageDTO(cri, memberService.getTotal()));

            return "admin/memberList";
        }

            memberDTOS = memberService.selectMember(auth.getName());

            model.addAttribute("result", memberDTOS);
            return "member/memberList";

    }

    // 회원 상세 조회
    @GetMapping("/detail/{memberId}")
    public String selectMemberDetail(@PathVariable int memberId, Model model) {
        log.info("::::::::::: 회원 상세조회  in controller ::::::::::::::");


        model.addAttribute("detail", memberService.selectDetailMember(memberId));
        return "member/memberDetail";
    }

    // 회원 정보 수정
    @GetMapping("/update/{memberId}")
    public String updateMember(@PathVariable int memberId, Model model) {

        log.info("::::::::::: 회원 정보 수정  in controller :::::::::::::::::");

        model.addAttribute("update", memberService.selectDetailMember(memberId));

        return "member/memberUpdate";
    }

    // 회원 정보 수정 완료
    @PostMapping("/update")
    public String updateMember(@ModelAttribute MemberDTO memberDTO) {

        log.info("::::::::::: 회원 정보 수정 완료 in controller  :::::::::::::::::::");
        memberService.memberUpdate(memberDTO);
        String memberId = Long.toString(memberDTO.getMemberId());

        return "redirect:/mypage/detail/" + memberId;
    }

    // 회원 탈퇴
    @PostMapping("/delete/{memberId}")
    public String deleteMember(@PathVariable int memberId) {

        log.info("::::::::::: 회원 탈퇴 ::::::::::::::::::::::::");
        memberService.memberDelete(memberId);

        return "redirect:/mypage/select";
    }

}

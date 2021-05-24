package com.team.NewLearn.controller.community;


import com.team.NewLearn.dto.community.CommunityDTO;
import com.team.NewLearn.dto.paging.Criteria;
import com.team.NewLearn.dto.paging.PageDTO;
import com.team.NewLearn.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class CommunityController {


    private final CommunityService communityService;

    @GetMapping("/community/select")
    private String CommunityBoardList(Criteria cri, Model model) {
        List<CommunityDTO> communityDTOS = new ArrayList<>();

//        communityDTOS = communityService.selectBoardAll(cri);
//
//        model.addAttribute("communityDTOS", communityDTOS);
//        model.addAttribute("pageMaker", new PageDTO(cri, communityService.getTotal(cri)));
////

        return "community/communityList";
    }

    @GetMapping("/detail/{id}")
    private String boardDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("detail", communityService.boardDetail(id));


            return "fileBoard/detail";
    }

    @PostMapping("/edit/{id}")
    private String boardEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("detail", communityService.boardDetail(id));
        return "fileBoard/update";
    }


    @PostMapping("/update")
    private String boardEditDone(CommunityDTO communityDTO) {

        communityService.boardUpdate(communityDTO);

        int bno = communityDTO.getId();
        String id = Integer.toString(bno);

        return "redirect:/detail/{id}";
    }

    @PostMapping("/delete/{id}")
    private String fileDelete(@PathVariable("id") int id) {
        communityService.boardDelete(id);

        return "redirect:/";
    }

    @GetMapping("/write")
    private String fileWrite(@ModelAttribute CommunityDTO communityDTO) {
        return "fileBoard/insert";
    }


    @PostMapping("/write")
    private String fileBoardInsertProc(@ModelAttribute CommunityDTO communityDTO) throws IllegalStateException, IOException, Exception {

            communityService.boardInsert(communityDTO);

        return "forward:/"; //객체 재사용
    }




}
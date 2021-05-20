package com.team.NewLearn.controller.main;

import com.team.NewLearn.dto.paging.Criteria;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String selectAllMember( Model model, Authentication auth) {

        model.addAttribute(model);
//        model.addAttribute(auth);
        return "main/index";
    }
}

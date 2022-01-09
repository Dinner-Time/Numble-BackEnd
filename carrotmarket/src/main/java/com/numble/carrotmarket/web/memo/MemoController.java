package com.numble.carrotmarket.web.memo;

import com.numble.carrotmarket.repository.memo.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoController {

    @Autowired
    MemoRepository memoRepository;

    @GetMapping("/memo/get/list")
    public String getList(Model model){
        model.addAttribute("memo", memoRepository.findAll());
        return "index";
    }
}

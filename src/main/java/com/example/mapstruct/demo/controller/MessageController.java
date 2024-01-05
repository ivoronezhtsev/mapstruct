package com.example.mapstruct.demo.controller;

import com.example.mapstruct.demo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("messages", messageService.getMy());
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("message", new MessageModel());
        return "message-info";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute("message") MessageModel messageModel) {
        messageService.add(messageModel);
        return "redirect:/";
    }
}
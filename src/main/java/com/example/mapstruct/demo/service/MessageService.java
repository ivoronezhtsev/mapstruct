package com.example.mapstruct.demo.service;

import com.example.mapstruct.demo.controller.MessageModel;
import com.example.mapstruct.demo.entity.Message;
import com.example.mapstruct.demo.repository.MessageRepository;
import com.example.mapstruct.demo.security.AppUserPrincipal;
import com.example.mapstruct.demo.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    public Set<Message> getMy() {
        Set<Message> result = new HashSet<>(messageRepository.findAllByToUser(getCurrentUser().getUser()));
        result.addAll(messageRepository.findAllByFromUser(getCurrentUser().getUser()));
        return result;
    }

    public void add(MessageModel messageModel) {
        Message message = new Message();
        message.setSendDate(LocalDateTime.now());
        message.setText(messageModel.getText());
        message.setFromUser(getCurrentUser().getUser());
        message.setToUser(userRepository.findByUsername(messageModel.getToUserName()));
        messageRepository.save(message);
    }

    private AppUserPrincipal getCurrentUser() {
        return (AppUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

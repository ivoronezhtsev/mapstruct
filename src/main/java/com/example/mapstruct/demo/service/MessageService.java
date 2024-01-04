package com.example.mapstruct.demo.service;

import com.example.mapstruct.demo.MessageModel;
import com.example.mapstruct.demo.entity.Message;
import com.example.mapstruct.demo.repository.MessageRepository;
import com.example.mapstruct.demo.security.AppUserPrincipal;
import com.example.mapstruct.demo.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    public List<Message> getMy() {
        List<Message> result = new ArrayList<>(messageRepository.findAllByToUser(getCurrentUser().getUser()));
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

package com.example.mapstruct.demo.repository;

import com.example.mapstruct.demo.entity.Message;
import com.example.mapstruct.demo.security.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAllByToUser(User user);
    List<Message> findAllByFromUser(User user);
}
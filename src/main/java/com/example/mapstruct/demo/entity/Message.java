package com.example.mapstruct.demo.entity;

import com.example.mapstruct.demo.security.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "to_user_id")
    private User toUser;

    private String text;

    private LocalDateTime sendDate;

}

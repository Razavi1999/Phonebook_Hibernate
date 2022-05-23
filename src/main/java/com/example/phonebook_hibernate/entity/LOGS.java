package com.example.phonebook_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOGS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LOGS {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Logger")
    private String logger;

    @Column(name = "level")
    private String level;

    @Column(name = "message")
    private String message;
}

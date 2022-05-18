package com.example.testMaven.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ContactGroup")
@Getter
@Setter
public class Group implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false , unique = true)
    @NotNull
    @NotBlank
    private String name;

    @ManyToMany
//    @JoinColumn(name = "contactId")
    private Set<Contact> contacts;


    public Group() {

    }
}

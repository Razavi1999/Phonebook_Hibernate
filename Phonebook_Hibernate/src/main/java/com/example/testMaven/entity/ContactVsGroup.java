package com.example.testMaven.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class ContactVsGroup {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
   private int contactId;

    @Column
   private String contactName;

    @Column
   private int groupId;

    @Column
   private String groupName;
}

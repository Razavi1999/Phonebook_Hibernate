package com.example.testMaven.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
@Getter
@Setter
public class Address implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "streetName")
    private String streetName;

    @Column(name = "alleyName")
    private String alleyName;

    @Column(name = "plaqueNumber")
    private int plaqueNumber;

    @OneToOne(mappedBy = "address")
    private Contact contact;

}

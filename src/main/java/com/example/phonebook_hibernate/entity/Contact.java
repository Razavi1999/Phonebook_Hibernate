package com.example.phonebook_hibernate.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Contact")
@Getter
@Setter
@AllArgsConstructor
public class Contact implements Serializable {
    public Contact() {

    }

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
//    @NotNull( message = "NotNull")
//    @NotBlank(message = "NotNull")
    private String firstName;

    @Column(name = "lastName")
//    @NotNull( message = "name.Error")
//    @NotBlank(message = "name.Error")
    private String lastName;

    //    @ContactNumberConstraint(message = "Invalid.phone.number")
    private String phoneNumber;

    @Column(name = "photo")
//    @NotNull
//    @NotBlank
    private String photo;

    public void setPhoto(String photo) {
        this.photo = photo;
        this.file = new File(photo);
    }

    @Column(name = "image")
    private byte[] image;

    @Column(name = "fileImage")
    private File file;


    @Column(name = "sex")
//    @NotNull
//    @NotBlank
    private Boolean sex;

    @Column(name = "alive")
    private Boolean alive;


    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "ContactVsGroup",
//            joinColumns = {@JoinColumn(name = "contactId")} ,
//            inverseJoinColumns = {@JoinColumn(name = "groupId")}
//    )
    private Set<Group> groups;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;


}

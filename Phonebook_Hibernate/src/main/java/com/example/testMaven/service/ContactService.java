package com.example.testMaven.service;

import com.example.testMaven.dto.ContactDto;
import com.example.testMaven.entity.Contact;

import java.util.List;

public interface ContactService {
    List<ContactDto> getAllContacts();

    void updateContact(int id , String newPhoneNumber);

    void updateContact(ContactDto dto);

    void deleteContact(int id);

    void createContact(String firstName ,
                       String lastName ,
                       String phoneNumber,
                       String photo
                       );

    Contact findById(int id);

    List<Contact> specificNames(String firstName , String lastName);
}

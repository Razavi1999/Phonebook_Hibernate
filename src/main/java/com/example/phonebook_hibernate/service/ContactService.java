package com.example.phonebook_hibernate.service;

import com.example.phonebook_hibernate.dto.ContactDto;
import com.example.phonebook_hibernate.entity.Contact;


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

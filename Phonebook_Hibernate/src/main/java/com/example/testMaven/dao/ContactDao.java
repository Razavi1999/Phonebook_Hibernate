package com.example.testMaven.dao;

import com.example.testMaven.dto.ContactDto;
import com.example.testMaven.entity.Contact;

import java.util.List;

public interface ContactDao {
    List<ContactDto> getAllContacts();

    void createContact(String firstName ,
                       String lastName ,
                       String phoneNumber ,
                       String photo
                       );

    void deleteContact(int id);

    void updateContactPhoneNumber(int id , String newNumber);

    void updateContact(ContactDto dto);

    List<Contact> getSpecificNames(String firstName ,
                                   String lastName
                                   );

    Contact findById(int id);

    List<Contact> getMaleContacts();

    List<Contact> getFemaleContacts();
}

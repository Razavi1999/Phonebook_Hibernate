package com.example.testMaven.mapper;


import com.example.testMaven.dto.ContactDto;
import com.example.testMaven.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactMapper {
    public List<ContactDto> ConvertToDTO(List<Contact> contactList){
        List<ContactDto> results = new ArrayList<>();
        for(Contact c : contactList){
            results.add(new ContactDto(
                    c.getId() ,
                    c.getFirstName() + " " + c.getLastName() ,
                    c.getPhoneNumber(),
                    c.getFile()
                    ));
        }
        return results;
    }

    public List<Contact> ConvertToEntity(List<ContactDto> contactList){
        return null;
    }

    public ContactDto ConvertToDTO(Contact contact){
        return new ContactDto(contact.getId() ,
                contact.getFirstName() + " " + contact.getLastName(),
                contact.getPhoneNumber(),
                contact.getFile()
                );
    }

}

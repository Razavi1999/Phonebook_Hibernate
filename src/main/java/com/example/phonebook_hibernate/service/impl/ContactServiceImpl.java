package com.example.phonebook_hibernate.service.impl;


import com.example.phonebook_hibernate.dao.impl.ContactDaoImpl;
import com.example.phonebook_hibernate.dto.ContactDto;
import com.example.phonebook_hibernate.entity.Contact;
import com.example.phonebook_hibernate.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
    private static Logger logger =  LoggerFactory.getLogger("ContactServiceImpl.class");

    @Autowired
    ContactDaoImpl contactDaoImpl;

    @Transactional
    public List<ContactDto> getAllContacts() {
        if(logger.isInfoEnabled())
            logger.info("Enter all");

        return contactDaoImpl.getAllContacts();
    }

    @Transactional
    public void updateContact(int id , String newPhoneNumber){
        try{
            contactDaoImpl.updateContactPhoneNumber(id , newPhoneNumber);
        }catch (Error | RuntimeException var){
            logger.error("id not found" , var);
            throw var;
        }

    }

    @Transactional
    public void updateContact(ContactDto dto){
        contactDaoImpl.updateContactPhoneNumber(dto.getId() , dto.getPhoneNumber());
    }

    @Transactional
    public void deleteContact(int id){
         contactDaoImpl.deleteContact(id);

    }

    @Transactional
    public void createContact(String firstName ,
                              String lastName ,
                              String phoneNumber ,
                              String photo){
        contactDaoImpl.createContact(firstName , lastName , phoneNumber , photo);
    }

    @Transactional
    public Contact findById(int id){
        Contact c =  contactDaoImpl.findById(id);
        System.out.println("ContactService.findById");
        return c;
    }

    @Transactional
    public List<Contact> specificNames(String firstName , String lastName){
        return contactDaoImpl.getSpecificNames(firstName , lastName);
    }

    @Transactional
    public List<Contact> maleContacts(){
        return contactDaoImpl.getMaleContacts();
    }

    @Transactional
    public List<Contact> femaleContacts(){
        return contactDaoImpl.getFemaleContacts();
    }

}

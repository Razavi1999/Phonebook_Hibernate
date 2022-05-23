package com.example.phonebook_hibernate.dao.impl;

import com.example.phonebook_hibernate.dao.ContactDao;
import com.example.phonebook_hibernate.dto.ContactDto;
import com.example.phonebook_hibernate.entity.Contact;
import com.example.phonebook_hibernate.mapper.ContactMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {
    @PersistenceContext
    EntityManager em;

    public List<ContactDto> getAllContacts() {
        ContactMapper mapper = new ContactMapper();
        return mapper.ConvertToDTO
                (em.createQuery("from Contact c order by c.id").getResultList());
    }

    public void createContact(String firstName ,
                              String lastName ,
                              String phoneNumber ,
                              String photo){
        Contact c = new Contact();
        c.setFirstName(firstName);
        c.setPhoto(photo);
        c.setLastName(lastName);
        c.setPhoneNumber(phoneNumber);
        em.merge(c);
    }


    public void deleteContact(int id){
        em.createQuery("delete from Contact c where c.id=:params")
                .setParameter("params" , id).executeUpdate();
    }

    public void updateContactPhoneNumber(int id , String newNumber){
        em.createQuery("update Contact c set c.phoneNumber=:param1 where c.id=:param2")
                .setParameter("param1" , newNumber)
                .setParameter("param2" , id).executeUpdate();

    }

    @Override
    public void updateContact(ContactDto dto) {

    }

    public List getSpecificNames(String firstName , String lastName){
        return em.createQuery("from Contact c where c.firstName LIKE :s1 AND" +
                                 " c.lastName LIKE :s2").setParameter("s1" , firstName)
                                                        .setParameter("s2" , lastName)
                                                        .getResultList();
    }

    public Contact findById(int id){
        ArrayList<Contact> c = (ArrayList<Contact>) em.createQuery("from Contact c where c.id=:params")
                .setParameter("params" , id).getResultList();

        if(c.size() == 0)
            return null;

        System.out.println("findById ");
        return c.get(0);
    }

    public List<Contact> getMaleContacts(){
        return (ArrayList<Contact>) em.createQuery("from Contact c where c.sex").getResultList();
    }

    public List<Contact> getFemaleContacts(){
        return (ArrayList<Contact>) em.createQuery("from Contact c where c.sex = false").getResultList();
    }



}

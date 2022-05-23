package com.example.phonebook_hibernate.dao.impl;

import com.example.phonebook_hibernate.dao.ContactVsGroupDao;
import com.example.phonebook_hibernate.entity.Contact;
import com.example.phonebook_hibernate.entity.ContactVsGroup;
import com.example.phonebook_hibernate.entity.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContactVsGroupDaoImpl implements ContactVsGroupDao {
    @PersistenceContext
    EntityManager em;


    public void showGroup(int groupId){
        List query = em.createQuery("from Group g join ContactVsGroup cg group by g.name").getResultList();

//        for(object item : query){
//            System.out.println(item);
//        }

    }

    public void showContact(int contactId){

    }

    public void addContactToGroup(int contactId , int groupId){
        Contact contact = (Contact) em.createQuery("from Contact c where c.id=:idParam").setParameter("idParam" , contactId).getResultList().get(0);
        Group group = (Group) em.createQuery("from Group g where g.id=:idParam").setParameter("idParam" , groupId).getResultList().get(0);
        ContactVsGroup cg = new ContactVsGroup();
        cg.setContactId(contactId);
        cg.setGroupId(groupId);
        cg.setContactName(contact.getFirstName() + " " + contact.getLastName());
        cg.setGroupName(group.getName());

        em.merge(cg);

    }

    public void deleteContactFromGroup(int contactId , int groupId){
        ContactVsGroup cg = (ContactVsGroup) em.createQuery("from ContactVsGroup cg where cg.contactId=:param1 and cg.groupId=:param2")
                .setParameter("param1" , contactId)
                .setParameter("param2" , groupId)
                .getResultList().get(0);

        em.remove(cg);
    }
}

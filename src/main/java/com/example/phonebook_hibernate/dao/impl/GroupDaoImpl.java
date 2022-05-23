package com.example.phonebook_hibernate.dao.impl;

import com.example.phonebook_hibernate.dao.GroupDao;
import com.example.phonebook_hibernate.entity.Contact;
import com.example.phonebook_hibernate.entity.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Repository
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    EntityManager em;

    public List<Group> getAllGroups(){
        return em.createQuery("from Group g order by g.id").getResultList();
    }

    public void createGroup(String name){
        Group g = new Group();
        Set<Contact> contacts = Collections.emptySet();

        g.setName(name);
        g.setContacts(contacts);
        em.merge(g);
//        return this.getAllGroups();
    }

    public void deleteGroup(int id){
        em.createQuery("delete Group g where g.id=:parameter")
                .setParameter("parameter" , id)
                .executeUpdate();
    }

    public void updateGroupName(int id, String name){
        em.createQuery("update Group g set g.name=:nameParam where g.id=:idParam")
                .setParameter("nameParam" , name)
                .setParameter("idParam" , id)
                .executeUpdate();
    }

    public Group findById(int id){
        List<Group> results = em.createQuery("from Group g where g.id=:idParam").setParameter("idParam" , id).getResultList();

        if(results.size() > 0)
            return results.get(0);

        else
            return null;
    }

}

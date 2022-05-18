package com.example.testMaven.service.impl;

import com.example.testMaven.dao.impl.ContactVsGroupDaoImpl;
import com.example.testMaven.service.ContactVsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("CotanctVsGroup")
public class ContactVsGroupServiceImpl implements ContactVsGroupService {
    @Autowired
    ContactVsGroupDaoImpl dao;

    @Transactional
    public void addContactToGroupService(int contactId , int groupId){
        dao.addContactToGroup(contactId, groupId);
    }

    @Transactional
    public void deleteContactFromGroupService(int contactId , int groupId){
        dao.deleteContactFromGroup(contactId , groupId);
    }
}

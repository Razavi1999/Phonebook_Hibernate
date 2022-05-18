package com.example.testMaven.service;

public interface ContactVsGroupService {
    void addContactToGroupService(int contactId , int groupId);

    void deleteContactFromGroupService(int contactId , int groupId);
}

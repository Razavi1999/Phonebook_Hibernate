package com.example.phonebook_hibernate.service;

public interface ContactVsGroupService {
    void addContactToGroupService(int contactId , int groupId);

    void deleteContactFromGroupService(int contactId , int groupId);
}

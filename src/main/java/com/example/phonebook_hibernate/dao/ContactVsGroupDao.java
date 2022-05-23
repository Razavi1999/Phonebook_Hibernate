package com.example.phonebook_hibernate.dao;

public interface ContactVsGroupDao {
    void showGroup(int group_id);

    void showContact(int contactId);

    void addContactToGroup(int contactId , int groupId);

    void deleteContactFromGroup(int contactId , int groupId);
}

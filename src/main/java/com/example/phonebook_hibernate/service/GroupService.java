package com.example.phonebook_hibernate.service;

import com.example.phonebook_hibernate.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> allGroupsService();

    void createGroupService(String name);

    void deleteGroupService(int id);

    void updateGroupNameService(int id , String name);

   Group findById(int id);
}

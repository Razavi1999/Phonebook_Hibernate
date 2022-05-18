package com.example.testMaven.dao;

import com.example.testMaven.entity.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroups();

    void createGroup(String name);

    void deleteGroup(int id);

    void updateGroupName(int id , String name);

    Group findById(int id);
}

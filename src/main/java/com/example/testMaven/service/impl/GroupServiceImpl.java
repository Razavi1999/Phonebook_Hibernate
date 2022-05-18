package com.example.testMaven.service.impl;

import com.example.testMaven.dao.impl.GroupDaoImpl;
import com.example.testMaven.entity.Group;
import com.example.testMaven.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupDaoImpl dao;

    @Transactional
    public List<Group> allGroupsService(){
        return dao.getAllGroups();
    }


    @Transactional
    public void createGroupService(String name){
        dao.createGroup(name);
    }

    @Transactional
    public void deleteGroupService(int id){
        dao.deleteGroup(id);
    }

    @Transactional
    public void updateGroupNameService(int id , String name){
        dao.updateGroupName(id , name);
    }

    @Transactional
    public Group findById(int id){
        return dao.findById(id);
    }
}

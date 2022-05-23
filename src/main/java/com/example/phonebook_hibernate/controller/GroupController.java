package com.example.phonebook_hibernate.controller;

import com.example.phonebook_hibernate.entity.Group;
import com.example.phonebook_hibernate.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(value = "/groups" ,
    method = {RequestMethod.POST , RequestMethod.GET}
)
public class GroupController {
    @Autowired
    GroupServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity getAllGroupsController(){
        return ResponseEntity.ok(service.allGroupsService());
    }

//    @GetMapping("/create")
//    public ResponseEntity createGroupController(@RequestParam("name") String name){
//        service.createGroupService(name);
//        return ResponseEntity.ok(service.allGroupsService());
//    }

    @PostMapping("/create")
    public ResponseEntity createGroupController(
            @RequestBody
            @Validated Group group){
        service.createGroupService(group.getName());
        return ResponseEntity.ok(service.findById(group.getId()));
    }

    @PostMapping("/delete")
    public ResponseEntity deleteGroupController(
            @RequestParam("id") int id){
        service.deleteGroupService(id);
        return ResponseEntity.ok(service.allGroupsService());
    }

    @PostMapping("/update")
    public ResponseEntity updateGroupNameController(@RequestParam("id") int id ,
                                                    @RequestParam("name") String name
                                                    ){
        service.updateGroupNameService(id , name);
        return ResponseEntity.ok(service.allGroupsService());
    }

    @PostMapping("/findById")
    public ResponseEntity findByIdController(@RequestParam("id") int id){
        if(service.findById(id) == null)
            return ResponseEntity.ok(Collections.emptyList());

        return ResponseEntity.ok(service.findById(id));
    }

}

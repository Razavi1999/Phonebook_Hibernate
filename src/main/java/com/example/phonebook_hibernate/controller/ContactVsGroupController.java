package com.example.phonebook_hibernate.controller;


import com.example.phonebook_hibernate.service.impl.ContactVsGroupServiceImpl;
import com.example.phonebook_hibernate.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ContactVsGroup" , method = {RequestMethod.GET , RequestMethod.POST})
public class ContactVsGroupController {
    @Autowired
    ContactVsGroupServiceImpl service;

    @Autowired
    GroupServiceImpl groupService;


    @PostMapping("/add")
    public ResponseEntity addContactToGroupController(@RequestParam("contactId") int contactId ,
                                                       @RequestParam("groupId") int groupId){
        service.addContactToGroupService(contactId, groupId);
        return ResponseEntity.ok(groupService.findById(groupId));
    }

    @PostMapping("/delete")
    public ResponseEntity deleteContactFrromGroupController(@RequestParam("contactId") int contactId ,
                                                            @RequestParam("groupId") int groupId){
        service.deleteContactFromGroupService(contactId , groupId);
        return ResponseEntity.ok(groupService.findById(groupId));
    }
}

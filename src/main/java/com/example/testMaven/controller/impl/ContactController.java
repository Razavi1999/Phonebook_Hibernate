package com.example.testMaven.controller.impl;

import com.example.testMaven.dto.ContactDto;
import com.example.testMaven.service.impl.ContactServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@RestController
@RequestMapping(value = "/contacts" ,
                method = {RequestMethod.POST , RequestMethod.GET}
)
public class ContactController {
    Logger logger =  LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    ContactServiceImpl service;

    @Autowired
    ResourceBundle resourceBundle;


//    @InitBinder
//    public void InitBinder(WebDataBinder dataBinder) {
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }


    @GetMapping("/getAll")
    public ResponseEntity allContacts(){
        logger.info("You Enter to allContacts");
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/findBy/{id}")
    public ResponseEntity findById(@PathVariable("id") int id){
        if(service.findById(id) == null)
            return ResponseEntity.ok(Collections.emptyList());

        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteContactController(@PathVariable("id") int id){
        service.deleteContact(id);
        return ResponseEntity.ok(service.getAllContacts());
    }

    @PostMapping("/delete/")
    public ResponseEntity deleteContactControllerWithRequestParam(@RequestParam int id){
        service.deleteContact(id);
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/create/{firstName}/{lastName}/{phoneNumber}/")
    public ResponseEntity createContactController
            (@PathVariable("firstName") String firstName,
                                                  @PathVariable("lastName") String lastName,
                                                  @PathVariable("phoneNumber") String phoneNumber,
                                                  @RequestParam("photo") String photo
                                                  ){
        String s = resourceBundle.getString("NotNull.contactDto.firstName");
        System.out.println(s);

        service.createContact(firstName , lastName , phoneNumber , photo);
        return ResponseEntity.ok(service.getAllContacts());
    }

    @PostMapping("/create")
    public ResponseEntity createContactController(@Valid @RequestBody  ContactDto contact){
        String s = resourceBundle.getString("NotNull.contactDto.firstName");
        System.out.println(s);

        service.createContact(
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getPhoneNumber(),
                    contact.getPhoto()
                );
        return ResponseEntity.ok(service.findById(contact.getId()));
    }


    @GetMapping("update/{id}/{newNumber}")
    public ResponseEntity updateContactController(@PathVariable("id") int id ,
                                                  @PathVariable("newNumber") String newNumber
                                                  ){
        service.updateContact(id , newNumber);
        return ResponseEntity.ok(service.getAllContacts());
    }

    @PostMapping("update")
    public ResponseEntity updateContactController(@Valid @RequestBody  ContactDto dto){
        service.updateContact(dto);
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/getSpecific/{firstName}/{lastName}")
    public ResponseEntity specificNames(@PathVariable("firstName") String firstName ,
                                        @PathVariable("lastName") String lastName
                                        ){
        return ResponseEntity.ok(service.specificNames(firstName , lastName));
    }


    @GetMapping("/males")
    public ResponseEntity maleContacts(){
        return ResponseEntity.ok(service.maleContacts());
    }

    @GetMapping("/females")
    public ResponseEntity femaleContacts(){
        return ResponseEntity.ok(service.femaleContacts());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public Map<String, String> handleValidationExceptions(BindException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = resourceBundle.getString(error.getDefaultMessage());
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

//    @ExceptionHandler(BindException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    ResponseMessage handleException(BindException e) {
//        SimpleValidateResults results = new SimpleValidateResults();
//        e.getBindingResult().getAllErrors()
//                .stream()
//                .filter(FieldError.class::isInstance)
//                .map(FieldError.class::cast)
//                .forEach(fieldError -> results.addResult(fieldError.getField(), fieldError.getDefaultMessage()));
//        return ResponseMessage.error(400, results.getResults().isEmpty() ? e.getMessage() : results.getResults().get(0).getMessage()).result(results.getResults());
//    }

}

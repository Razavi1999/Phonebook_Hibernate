package com.example.testMaven.dto;

import com.example.testMaven.InterfaceAnnotation.ContactNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto implements Serializable {
    private int id;

    public ContactDto(int id, String fullName, String phoneNumber, File file) {
        this.id = id;
        //this.firstName = firstName;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.file = file;
    }



    @NotNull(message = "NotNull.contactDto.firstName")
    private String firstName;

    @NotNull(message = "NotNull.contactDto.firstName")
    @NotBlank(message = "NotNull.contactDto.firstName")
    private String lastName;

    @NotBlank(message = "NotNull.contactDto.firstName")
    private String fullName;

    @ContactNumberConstraint(message = "Invalid.phone.number")
    private String phoneNumber;

    private String photo;
    private File file;
}

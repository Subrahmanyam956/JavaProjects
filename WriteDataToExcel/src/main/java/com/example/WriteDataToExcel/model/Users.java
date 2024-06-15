package com.example.WriteDataToExcel.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
}

package com.example.ravi.healthcare.model;

import java.util.Date;

/**
 * Created by admin on 31-03-2017.
 */

public class Patient {
    Long id;
    String firstName;
    String lastName;
    String mobile;
    String dateOfBirth;

   public Patient(String firstName, String lastName, String mobile,String date ){
        this.firstName=firstName;
        this.lastName=lastName;
        this.mobile=mobile;
        this.dateOfBirth=date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

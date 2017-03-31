package com.example.ravi.healthcare.model;

/**
 * Created by admin on 28-03-2017.
 */

public class Error {
    String invalidValue;
    String message;
    String propertyName;

    Error(){

    }

    Error(String code, String message, String prop){
    this.invalidValue=code;
        this.message=message;
        this.propertyName=prop;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}

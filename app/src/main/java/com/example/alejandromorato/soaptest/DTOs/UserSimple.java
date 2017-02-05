package com.example.alejandromorato.soaptest.DTOs;

public class UserSimple {
    String name;
    String email;
    int age;
    boolean isDeveloper;

    public UserSimple(String nameIn, String emailIn, int ageIn, boolean isDeveloperIn)
    {
        name = nameIn;
        email = emailIn;
        age = ageIn;
        isDeveloper = isDeveloperIn;
    }
}

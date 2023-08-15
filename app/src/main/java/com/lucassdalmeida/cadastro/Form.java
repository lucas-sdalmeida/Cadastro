package com.lucassdalmeida.cadastro;

import androidx.annotation.NonNull;

public class Form {
    private String name;
    private String phoneNumber;
    private String email;
    private boolean addEmailToList;
    private String gender;
    private String city;
    private String uf;

    public boolean hasAllFieldFilled() {
        return isFilled(name) && isFilled(phoneNumber) && isFilled(email) &&
                isFilled(gender) && isFilled(city) && isFilled(uf);
    }

    public void resetFields() {
        name = "";
        phoneNumber = "";
        email = "";
        addEmailToList = false;
        gender = "";
        city = "";
        uf = "";
    }

    private static boolean isFilled(String string) {
        return !(string == null || string.isEmpty());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAddEmailToList() {
        return addEmailToList;
    }

    public void setAddEmailToList(boolean addEmailToList) {
        this.addEmailToList = addEmailToList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: '" + name + '\'' +
                "; Phone Number: '" + phoneNumber + '\'' +
                "; E-mail: '" + email + '\'' +
                "; add e-mail To List? " + addEmailToList +
                "; gender: '" + gender + '\'' +
                "; city: '" + city + '\'' +
                ", UF: '" + uf + '\'';
    }
}

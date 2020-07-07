package com.example.blooddonationapp.models;

public class User {
   String uid,userName,password,email,phone,gender,bloodgrp,address,work;

    public User(String uid, String userName, String password, String email, String phone, String gender, String bloodgrp, String address, String work) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.bloodgrp = bloodgrp;
        this.address = address;
        this.work = work;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}

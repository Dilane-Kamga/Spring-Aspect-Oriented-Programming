package com.aop.springaopdemo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class User {

    public String getUserDetails() {
        return "User Details";
    }
}

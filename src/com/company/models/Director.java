package com.company.models;

public class Director {

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "\ndirector - " + fullName ;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}


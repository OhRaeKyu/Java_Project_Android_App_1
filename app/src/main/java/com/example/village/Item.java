package com.example.village;

public class Item {

private String username;
private String profile;

    public Item(){}

    public Item(String userName, String profile) {
        this.username = userName;
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

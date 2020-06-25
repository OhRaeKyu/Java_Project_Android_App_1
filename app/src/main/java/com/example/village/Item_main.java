package com.example.village;

public class Item_main {

    private String username;
    private String profile;

    public Item_main(){}

    public Item_main(String userName, String profile) {
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

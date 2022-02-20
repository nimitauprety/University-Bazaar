package com.example.cse3310defaultproject;

public class UserInfo {

    private String pass;
    private String utaId;
    private String firstName;
    private String lastName;
    private String email;
    private String post;

    public UserInfo(String utaId, String firstName, String lastName, String email, String pass) {
        this.utaId = utaId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
    }

    public String getUtaId() {
        return utaId;
    }

    public void setUtaId(String utaId) {
        this.utaId = utaId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

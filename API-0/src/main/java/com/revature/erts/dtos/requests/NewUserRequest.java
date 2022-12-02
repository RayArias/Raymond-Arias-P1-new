package com.revature.erts.dtos.requests;

public class NewUserRequest {
    private String username;
    private String email;
    private String givenName;
    private String surname;
    private String password1;
    private String password2;

    public NewUserRequest() {
        super();
    }

    public NewUserRequest(String username, String email, String givenName, String surname, String password1,
                          String password2) {
        this.username  = username;
        this.email     = email;
        this.givenName = givenName;
        this.surname   = surname;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    public String getGivenName() { return this.givenName; }

    public void setGivenName(String givenName) { this.givenName = givenName; }

    public String getSurname() { return this.surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getPassword1() { return this.password1; }

    public void setPassword1(String password1) { this.password1 = password1; }

    public String getPassword2() { return password2; }

    public void setPassword2(String password2) { this.password2 = password2; }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "username='" + username + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}

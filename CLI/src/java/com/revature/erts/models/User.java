package com.revature.erts.models;

import java.util.UUID;

public class User {

    private String id;
    private String username;
    private String email;
    private String givenName;
    private String surname;
    private String password;
    private UserRole role;
    private String approvalId;
    private String authId;
    private boolean filler = true;

    User() {  // System Admin Info

        this.id         = "c26de9cb-cac3-401c-b324-3f7cd0b82845";
        this.username   = "erts-admin";
        this.email      = "admin@erts.net";
        this.givenName  = "System";
        this.surname    = "Admin";
        this.password   = "pa55w0rd";
        this.role       = UserRole.ADMIN;
        this.authId     = "DEFAULT";
        this.approvalId = "DEFAULT";

    }

    User(String id, String username, String email, UserRole role) {

        this.id       = id;
        this.username = username;
        this.email    = email;
        this.role     = role;

    }

    User(String id, String username, String email, String roleUUID) {

        this.id       = id;
        this.username = username;
        this.email    = email;
        this.role     = DatatypeCrossRef.roleUUID2Enum(roleUUID);

    }

    User(String id, String username, String email, UserRole role, String authId) {

        this.id       = id;
        this.username = username;
        this.email    = email;
        this.role     = role;
        this.authId   = authId;

    }

    User(String id, String username, String email, String roleUUID, String authId) {

        this.id       = id;
        this.username = username;
        this.email    = email;
        this.role     = DatatypeCrossRef.roleUUID2Enum(roleUUID);
        this.authId   = authId;

    }

    User(String id, String username, String email, String givenName, String surname, UserRole role, String authId) {

        this.id        = id;
        this.username  = username;
        this.email     = email;
        this.givenName = givenName;
        this.surname   = surname;
        this.role      = role;
        this.authId    = authId;

    }

    User(String id, String username, String email, String givenName, String surname, UserRole role, String authId,
         boolean filler, String approvalId) {

        this.id         = id;
        this.username   = username;
        this.email      = email;
        this.givenName  = givenName;
        this.surname    = surname;
        this.role       = role;
        this.authId     = authId;
        this.approvalId = approvalId;

    }

    User(String id, String username, String email, String givenName, String surname, String roleUUID, String authId,
         boolean filler, String approvalId) {

        this.id         = id;
        this.username   = username;
        this.email      = email;
        this.givenName  = givenName;
        this.surname    = surname;
        this.role       = DatatypeCrossRef.roleUUID2Enum(roleUUID);
        this.authId     = authId;
        this.approvalId = approvalId;

    }

    User(String id, String username, String email, String givenName, String surname, String roleUUID, String authId) {

        this.id        = id;
        this.username  = username;
        this.email     = email;
        this.givenName = givenName;
        this.surname   = surname;
        this.role      = DatatypeCrossRef.roleUUID2Enum(roleUUID);
        this.authId    = authId;

    }


    User(String id, String username, String email, String givenName, String surname, String password, UserRole role,
         String authId, boolean filler, String approvalId) {

        this.id         = id;
        this.username   = username;
        this.email      = email;
        this.givenName  = givenName;
        this.surname    = surname;
        this.password   = password;
        this.role       = role;
        this.authId     = authId;
        this.approvalId = approvalId;

    }

    User(String id, String username, String email, String givenName, String surname, String password, UserRole role,
         String authId) {

        this.id        = id;
        this.username  = username;
        this.givenName = givenName;
        this.surname   = surname;
        this.password  = password;
        this.role      = role;
        this.authId    = authId;

    }

    User(String id, String username, String email, String givenName, String surname, String password, String roleUUID,
         String authId, boolean filler, String approvalId) {

        this.id         = id;
        this.username   = username;
        this.email      = email;
        this.givenName  = givenName;
        this.surname    = surname;
        this.password   = password;
        this.role       = DatatypeCrossRef.roleUUID2Enum(roleUUID);
        this.authId     = authId;
        this.approvalId = approvalId;

    }

    User(String id, String username, String email, String givenName, String surname, String password, String roleUUID,
         String authId) {

        this.id        = id;
        this.username  = username;
        this.email     = email;
        this.givenName = givenName;
        this.surname   = surname;
        this.password  = password;
        this.role      = DatatypeCrossRef.roleUUID2Enum(roleUUID);
        this.authId    = authId;

    }

    public String getId() { return this.id; }

    public void assignId() { this.id = String.valueOf(UUID.randomUUID()); }
    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    public String getGivenName() { return this.givenName; }

    public void setGivenName(String givenName) { this.givenName = givenName; }

    public String getSurname() { return this.surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

    public UserRole getRole() { return this.role; }

    public void setRole(UserRole role) { this.role = role; }

    public String getRoleText() { return DatatypeCrossRef.roleEnum2Text(this.role); }

    public void setRoleText(String roleText) { this.role = DatatypeCrossRef.roleText2Enum(roleText); }

    public String getRoleUUID() { return DatatypeCrossRef.roleEnum2UUID(this.role); }

    public void setRoleUUID(String roleUUID) { this.role = DatatypeCrossRef.roleUUID2Enum(roleUUID); }


    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "User{"           +
                "id='"           + this.id                                   + '\'' +
                ", username='"   + this.username                             + '\'' +
                ", email='"      + this.email                                + '\'' +
                ", givenName='"  + this.givenName                            + '\'' +
                ", surname='"    + this.surname                              + '\'' +
                ", roleUUID='"   + DatatypeCrossRef.roleEnum2UUID(this.role) + '\'' +
                ", roleText='"   + DatatypeCrossRef.roleEnum2Text(this.role) + '\'' +
                ", approvalId='" + this.approvalId                           + '\'' +
                ", authId='"     + this.authId                               + '\'' +
                '}';
    }
}

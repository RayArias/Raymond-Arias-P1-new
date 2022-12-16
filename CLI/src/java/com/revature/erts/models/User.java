package com.revature.erts.models;

public class User {

    String id;
    String username;
    String email;
    String givenName;
    String surname;
    String password;
    UserRole role;
    String approvalId;
    String authId;
    boolean filler = true;

    User() {

        this.id = "";
        this.username = "";
        this.email = "";
        this.givenName = "";
        this.surname = "";
        this.password = "";
        this.role = UserRole.ADMIN;
        this.authId = "DEFAULT";
        this.approvalId = "DEFAULT";

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

}

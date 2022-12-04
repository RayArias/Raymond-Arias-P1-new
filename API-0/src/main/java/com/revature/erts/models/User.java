package com.revature.erts.models;

import com.revature.erts.models.UserRole;
import com.revature.erts.models.DatatypeCrossRef;

public class User {
    private String id;
    private String username;
    private String email;
    private String givenName;
    private String surname;
    private String password;
    private UserRole role;
    private String promotionApprovalID;
    private String authID;
    private boolean constructorIncludesPromoID;

    public User() {
        super();
    }

    public User(String id, String username, String email, String givenName, String surname, String password,
                UserRole role) {
        this.id        = id;
        this.username  = username;
        this.email     = email;
        this.givenName = givenName;
        this.surname   = surname;
        this.password  = password;
        this.role      = role;
    }

    public User(String id, String username, String email, String givenName, String surname, String password,
                String roleUUID) {
        this.id        = id;
        this.username  = username;
        this.email     = email;
        this.givenName = givenName;
        this.surname   = surname;
        this.password  = password;
        this.role      = DatatypeCrossRef.userRoleUUID2Enum(roleUUID);
    }

    public User(String id, String username, String email, String givenName, String surname, String password,
                UserRole role, String authID) {
        this.id        = id;
        this.username  = username;
        this.email     = email;
        this.givenName = givenName;
        this.surname   = surname;
        this.password  = password;
        this.role      = role;
        this.authID    = authID;
    }

    public User(String id, String username, String email, String givenName, String surname, String password,
                UserRole role, boolean constructorIncludesPromoID, String promotionApprovalID) {
        this.id                  = id;
        this.username            = username;
        this.email               = email;
        this.givenName           = givenName;
        this.surname             = surname;
        this.password            = password;
        this.role                = role;
        this.promotionApprovalID = promotionApprovalID;
    }

    public User(String id, String username, String email, String givenName, String surname, String password,
                UserRole role, boolean constructorIncludesPromoID, String promotionApprovalID, String authID) {
        this.id                  = id;
        this.username            = username;
        this.email               = email;
        this.givenName           = givenName;
        this.surname             = surname;
        this.password            = password;
        this.role                = role;
        this.promotionApprovalID = promotionApprovalID;
        this.authID              = authID;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    public String getGivenName() { return this.givenName; }

    public void setGivenName(String givenName) { this.givenName = givenName; }

    public String getSurname() { return this.surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }
    public UserRole getRole() {
        return this.role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getRoleUUID() { return DatatypeCrossRef.userRoleEnum2UUID(this.role); }

    public void setRoleByUUID(String roleUUID) { this.role = DatatypeCrossRef.userRoleUUID2Enum(roleUUID); }

    public String getRoleText() { return DatatypeCrossRef.userRoleEnum2Text(this.role); }

    public void setRoleByText(String roleText) { this.role = DatatypeCrossRef.userRoleText2Enum(roleText); }

    public String getAuthID() { return this.authID; }

    public String getPromotionApprovalID() {
        return this.promotionApprovalID;
    }

    public void setPromotionApprovalID(String promotionApprovalID) {
        this.promotionApprovalID = promotionApprovalID;
    }

    @Override
    public String toString() {
        return "User{"                    +
                "id='"                    + this.id                  + '\'' +
                ", username='"            + this.username            + '\'' +
                ", email='"               + this.email               + '\'' +
                ", givenName='"           + this.givenName           + '\'' +
                ", surname='"             + this.surname             + '\'' +
                ", roleUUID='"            + getRoleUUID()            + '\'' +
                ", roleText='"            + getRoleText()            + '\'' +
                ", promotionApprovalID'"  + this.promotionApprovalID + '\'' +
                ", authID'"               + this.authID              + '\'' +
                '}';
    }
}

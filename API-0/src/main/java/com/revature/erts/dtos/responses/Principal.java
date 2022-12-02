package dtos.responses;

import com.revature.erts.models.UserRole;
import models.DatatypeCrossRef;

public class Principal {
    private String userUUID;
    private String username;
    private UserRole role;

    private String authID;

    public Principal() {
        super();
    }

    public Principal(String userUUID, String username, UserRole role, String authID) {
        this.userUUID  = userUUID;
        this.username  = username;
        this.role      = role;
        this.authID    = authID;
    }

    public Principal(String userUUID, String username, String roleUUID) {
        this.userUUID = userUUID;
        this.username = username;
        this.role     = DatatypeCrossRef.userRoleUUID2Enum(roleUUID);
    }

    public String getUserUUID() {
        return this.userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) { this.username = username; }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getRoleText() { return DatatypeCrossRef.userRoleEnum2Text(this.role); }

    public void setRole(String roleString) { this.role = DatatypeCrossRef.userRoleText2Enum(roleString);  }

    public String getRoleUUID() { return DatatypeCrossRef.userRoleEnum2UUID(this.role); }

    public void setRoleUsingUUID(String roleUUID) { this.role = DatatypeCrossRef.userRoleUUID2Enum(roleUUID); }

    public String getAuthID() { return this.authID; }

    @java.lang.Override
    public java.lang.String toString() {
        return "Principal{" +
                "userUUID='" + userUUID + '\'' +
                ", username='" + username + '\'' +
                ", roleUUID='" + getRoleUUID() +
                ", roleText='" + getRoleText() +
                ", authID='" + authID +
                '}';
    }
}

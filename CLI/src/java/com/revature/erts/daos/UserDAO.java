package com.revature.erts.daos;

import com.revature.erts.models.User;
import com.revature.erts.models.UserRole;

public class UserDAO implements CRUD_DAO<User> {

    String id;
    String username;
    String email;
    String givenName;
    String surname;
    String password;
    UserRole role;
    String approvalId;
    boolean filler = true;





}

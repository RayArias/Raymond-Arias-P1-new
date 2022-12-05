package com.revature.erts.utils;

import com.revature.erts.daos.UserDAO;
import com.revature.erts.daos.ReimbursementDAO;
import com.revature.erts.handlers.AuthHandler;
import com.revature.erts.handlers.UserHandler;
import com.revature.erts.handlers.ReimbursementHandler;
import com.revature.erts.services.TokenService;
import com.revature.erts.services.UserService;
import com.revature.erts.services.ReimbursementService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

/* purpose of router class is to map endpoints */
public class Router {
    public static void router(Javalin app) {

        ObjectMapper mapper = new ObjectMapper();
        JwtConfig jwtConfig = new JwtConfig();
        TokenService tokenService = new TokenService(jwtConfig);

        /* User */
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        UserHandler userHandler = new UserHandler(userService, tokenService, mapper);

        /* auth */
        AuthHandler authHandler = new AuthHandler(userService, tokenService, mapper);

        /* Reimbursement */
        ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
        ReimbursementService reimbursementService = new ReimbursementService(reimbursementDAO);
        ReimbursementHandler reimbursementHandler = new ReimbursementHandler(reimbursementService, tokenService,
                mapper);

        /* handler groups */
        /* routes -> handler -> service -> dao */
        app.routes(() -> {
            /* user */
            path("/users", () -> {
                get(userHandler::getAllUsers);
                get("/name", userHandler::getAllUsersByUsername);
                post(c -> userHandler.signup(c));
            });

            /* auth */
            path("/auth", () -> {
                post(authHandler::authenticateUser);
            });

            /* reimbursement */
            path("/reimbursements", () -> {
                get(reimbursementHandler::getAllReimbursements);
                get("/fromUser", reimbursementHandler::getAllReimbursementsByUserUUID);
                post(c -> reimbursementHandler.newReimbursement(c));
            });
        });
    }
}
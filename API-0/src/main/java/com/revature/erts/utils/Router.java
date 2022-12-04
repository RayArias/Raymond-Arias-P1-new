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

        DebugAndTrace.trace("Welcome to Router class!");

        ObjectMapper mapper = new ObjectMapper();
        DebugAndTrace.trace("Creating JwtConfig object...");
        JwtConfig jwtConfig = new JwtConfig();
        DebugAndTrace.trace("Using JwtConfig object as param to create TokenService object...");
        TokenService tokenService = new TokenService(jwtConfig);

        /* User */

        DebugAndTrace.trace("Creating UserDAO object...");
        UserDAO userDAO = new UserDAO();
        DebugAndTrace.trace("Using userDAO object to create UserService object...");
        UserService userService = new UserService(userDAO);
        DebugAndTrace.trace("Using UserService and TokenService objects to create UserHandler object...");
        UserHandler userHandler = new UserHandler(userService, tokenService, mapper);

        /* auth */
        DebugAndTrace.trace("Using UserService and TokenService objects to create AuthHandler object...");
        AuthHandler authHandler = new AuthHandler(userService, tokenService, mapper);

        /* Reimbursement */
        DebugAndTrace.trace("Creating new ReimbursementDAO object...");
        ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
        DebugAndTrace.trace("Using ReimbursementDAO object to create new ReimbursementService object...");
        ReimbursementService reimbursementService = new ReimbursementService(reimbursementDAO);
        DebugAndTrace.trace("Using ReimbursementService and TokenService objects to creating new " +
                "ReimbursementHandler object...");
        ReimbursementHandler reimbursementHandler = new ReimbursementHandler(reimbursementService, tokenService,
                mapper);

        /* handler groups */
        /* routes -> handler -> service -> dao */
        DebugAndTrace.trace("Creating app.routes...");
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
        });
        DebugAndTrace.trace("App.routes created!");
        DebugAndTrace.trace("Handing back to MainDriver class...");
    }
}
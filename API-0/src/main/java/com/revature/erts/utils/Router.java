package utils;

import daos.UserDAO;
import java.com.revature.erts.daos.ReimbursementDAO;
import handlers.AuthHandler;
import handlers.UserHandler;
import handlers.ReimbursementHandler;
import services.TokenService;
import services.UserService;
import services.ReimbursementService;
import com.revature.erts.utils.JwtConfig;

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
        ReimbursementService reimbursementService = new ReimbursementService();
        ReimbursementHandler reimbursementHandler = new ReimbursementHandler();

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
        });
    }
}
package com.revature.erts;

import com.revature.erts.utils.ConnectionFactory;
import com.revature.erts.utils.Router;
import io.javalin.Javalin;

/* purpose of this class is to start our application */
public class MainDriver {
    public static void main(String[] args) {
        Javalin app = Javalin.create(c -> {
            c.contextPath = "/erts";
        }).start(8080);

        Router.router(app);
    }
}
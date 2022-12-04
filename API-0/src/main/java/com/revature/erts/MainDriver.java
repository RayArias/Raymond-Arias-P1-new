package com.revature.erts;

import com.revature.erts.utils.ConnectionFactory;
import com.revature.erts.utils.Router;
import com.revature.erts.utils.DebugAndTrace;
import io.javalin.Javalin;

/* purpose of this class is to start our application */
public class MainDriver {
    public static void main(String[] args) {
        Javalin app = Javalin.create(c -> {
            c.contextPath = "/ers";
        }).start(8080);

        DebugAndTrace.trace("Welcome to MainDriver class!");
        DebugAndTrace.trace("Handing off to Router class...");
        Router.router(app);
        DebugAndTrace.trace("Welcome back to MainDriver class!");
        System.out.println("ERTS 1.0.0 is running! \\o/");
    }
}
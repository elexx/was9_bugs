package at.struct.was9bugs.bug17;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    private @Inject MyEjb myEjb;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("STARTUP!");
        myEjb.doSomething("starting");
        System.out.println("FINISHED STARTUP!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("SHUTDOWN!");
        myEjb.doSomething("shutting down");
        System.out.println("FINISHED SHUTDOWN!");
    }
}

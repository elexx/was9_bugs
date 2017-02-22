package at.struct.was9bugs.bug11;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class MyAutostartService {

    private static final Logger log = Logger.getLogger(MyAutostartService.class.getName());

    public void onInitialize(@Observes @Initialized(ApplicationScoped.class) Object o, MyService myService) {
        log.log(Level.INFO, "I SHOULD HAVE BEEN CALLED!");
        myService.setSomeValue("autostarted!");
    }
}

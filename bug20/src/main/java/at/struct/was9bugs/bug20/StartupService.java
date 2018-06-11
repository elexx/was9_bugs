package at.struct.was9bugs.bug20;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@RequestScoped
public class StartupService {
    private static final Logger log = Logger.getLogger(StartupService.class.getName());

    private @Inject MyService service;

    public String load() {
        log.log(Level.INFO, "load");

        service.cleanDB();
        service.crashit();

        return "loaded";
    }
}

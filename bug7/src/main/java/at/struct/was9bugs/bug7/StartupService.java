package at.struct.was9bugs.bug7;

import at.struct.was9bugs.bug7.entities.MyEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Named
public class StartupService {
    private static final Logger log = Logger.getLogger(StartupService.class.getName());

    private @Inject MyService myService;

    public List<MyEntity> load() {
        log.log(Level.INFO, "started");
        myService.fillDB();

        return myService.query();
    }

}

package at.struct.was9bugs.bug6;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Named
public class StartupService {
    private static final Logger log = Logger.getLogger(StartupService.class.getName());

    private @Inject EntityManager em;

    public int load() {
        log.log(Level.INFO, "started");

        int result = (int) em.createNativeQuery("SELECT 1 FROM DUAL", Integer.class).getSingleResult();
        log.log(Level.INFO, "selected: {0} ", result);
        return result;
    }
}

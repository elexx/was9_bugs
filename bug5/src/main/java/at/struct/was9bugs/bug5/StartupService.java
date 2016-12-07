package at.struct.was9bugs.bug5;

import at.struct.was9bugs.bug5.entities.MyEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Named
public class StartupService {
    private static final Logger log = Logger.getLogger(StartupService.class.getName());

    private @Inject EntityManager em;

    public String load() {
        log.log(Level.INFO, "started");

        List<MyEntity> resultList = em.createQuery("SELECT e FROM MyEntity e", MyEntity.class).getResultList();
        log.log(Level.INFO, "found {0} entries", resultList.size());
        return Integer.toString(resultList.size());
    }
}

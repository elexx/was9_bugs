package at.struct.was9bugs.bug4;

import at.struct.was9bugs.bug4.entities.ChildEntity;
import at.struct.was9bugs.bug4.entities.ParentEntity;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
@Transactional
public class MyService {
    private static final Logger log = Logger.getLogger(MyService.class.getName());

    @Inject private EntityManager em;

    public void cleanDB() {
        log.log(Level.INFO, "cleanDB");
        em.createQuery("DELETE FROM ChildEntity e").executeUpdate();
        em.createQuery("DELETE FROM ParentEntity e").executeUpdate();
        em.createQuery("DELETE FROM ParentBaseEntity e").executeUpdate();
    }

    public long crashit() {
        log.log(Level.INFO, "crashit");

        ParentEntity parent = new ParentEntity();
        em.persist(parent);

        ChildEntity child = new ChildEntity();
        child.setParent(parent);
        em.persist(child);

        log.log(Level.INFO, "child: {0}, parent: {1}", new Object[]{child.getId(), parent.getId()});
        return parent.getId();
    }
}

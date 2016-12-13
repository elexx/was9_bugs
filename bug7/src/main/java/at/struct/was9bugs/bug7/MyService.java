package at.struct.was9bugs.bug7;

import at.struct.was9bugs.bug7.entities.MyEntity;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Transactional
public class MyService {

    private @Inject EntityManager em;

    public void fillDB() {
        em.createQuery("DELETE FROM MyEntity e").executeUpdate();

        createEntity(true, true);
        createEntity(false, false);
        createEntity(true, null);
    }

    public List<MyEntity> query() {
        return em.createQuery("SELECT e FROM MyEntity e", MyEntity.class).getResultList();
    }

    private void createEntity(boolean somedata, Boolean moredata) {
        MyEntity e = new MyEntity();
        e.setSomedata(somedata);
        e.setMoredata(moredata);
        em.persist(e);
    }
}

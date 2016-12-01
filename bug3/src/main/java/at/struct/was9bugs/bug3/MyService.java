package at.struct.was9bugs.bug3;

import at.struct.was9bugs.bug3.entities.ChildEntity;
import at.struct.was9bugs.bug3.entities.ParentEntity;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
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
    }

    public long fillDB(int amountOfChildren) {
        log.log(Level.INFO, "fillDB amountOfChilren={0}", amountOfChildren);
        ParentEntity p = new ParentEntity();
        List<ChildEntity> children = new ArrayList<>();

        for (int i = 0; i < amountOfChildren; i++) {
            children.add(createChild(p));
        }

        p.setChildren(children);

        em.persist(p);
        return p.getId();
    }

    public ParentEntity loadParent(long id) {
        log.log(Level.INFO, "loadParent id={0}", id);
        return em.find(ParentEntity.class, id);
    }

    public ParentEntity removeChildrenAndGetParent(long childToBeRemovedId, long parentId) {
        log.log(Level.INFO, "removeChildrenAndGetParent childToBeRemovedId={0} parentId={1}", new Object[]{childToBeRemovedId, parentId});
        ChildEntity child = em.find(ChildEntity.class, childToBeRemovedId);
        em.remove(child);

        return em.find(ParentEntity.class, parentId);
    }

    private ChildEntity createChild(ParentEntity p) {
        ChildEntity c = new ChildEntity();
        c.setParent(p);
        return c;
    }
}

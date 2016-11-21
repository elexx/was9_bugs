package at.struct.was9bugs.bug2;

import at.struct.was9bugs.bug2.entities.AnotherEntity;
import at.struct.was9bugs.bug2.entities.SimpleEntity;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
@Transactional
public class MyService {

    @Inject private EntityManager em;

    public void fillDB() {
        em.createQuery("DELETE FROM SimpleEntity e").executeUpdate();
        em.createQuery("DELETE FROM AnotherEntity e").executeUpdate();

        createAnotherEntity("valueA");
        createAnotherEntity("valueB");

        createSimpleEntity("a");
        createSimpleEntity("a");
        createSimpleEntity("a");
        createSimpleEntity("b");
    }

    public List<Object[]> query() {
        Query nativeQuery = em.createNativeQuery(
                "SELECT a.somevalue," +
                " SUM(CASE s.somevalue WHEN 'a' THEN 1 ELSE 0 END)" +
                " FROM SimpleEntity s, AnotherEntity a" +
                " GROUP BY a.somevalue");
        return (List<Object[]>) nativeQuery.getResultList();
    }

    private void createAnotherEntity(String value) {
        AnotherEntity a = new AnotherEntity();
        a.setSomevalue(value);
        em.persist(a);
    }

    private void createSimpleEntity(String v) {
        SimpleEntity s = new SimpleEntity();
        s.setSomevalue(v);
        em.persist(s);
    }
}

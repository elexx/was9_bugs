package at.struct.was9bugs.bug20;

import at.struct.was9bugs.bug20.entities.Comment;
import at.struct.was9bugs.bug20.entities.Post;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
@Transactional
public class MyService {
    private static final Logger log = Logger.getLogger(MyService.class.getName());

    @Inject private EntityManager em;

    public void cleanDB() {
        log.log(Level.INFO, "cleanDB");
        em.createQuery("DELETE FROM Comment c").executeUpdate();
        em.createQuery("DELETE FROM Post p").executeUpdate();
    }

    public long crashit() {
        log.log(Level.INFO, "crashit");

        em.createNativeQuery("set constraints all deferred")
                .executeUpdate();

        Post post = new Post();

        post.setComments(new ArrayList<>());
        post.getComments().add(new Comment());
        post.getComments().add(new Comment());
        post.getComments().add(new Comment());

        em.persist(post);

        return post.getId();
    }
}

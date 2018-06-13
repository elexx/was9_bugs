package at.struct.was9bugs.bug21;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class PrincipalProducer {

    private final AtomicInteger userCount = new AtomicInteger(1);

    @Produces
    @RequestScoped
    @Typed(MyPrincipal.class)
    @Named("currentUser")
    public MyPrincipal produce() {
        // This is implified. In a real world applicationthe user gets derived from an LTPA login (request.getRemoteUser())
        MyPrincipal myPrincipal = new MyPrincipal();
        myPrincipal.setName("JaneDoe" + userCount.getAndIncrement());
        return myPrincipal;
    }
}

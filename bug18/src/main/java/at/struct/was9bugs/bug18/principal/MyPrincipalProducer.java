package at.struct.was9bugs.bug18.principal;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import javax.inject.Named;

@ApplicationScoped
public class MyPrincipalProducer {

    @Produces
    @RequestScoped
    @Typed(MyPrincipal.class)
    @Named("currentUser")
    public MyPrincipal createPrincipal() {
        return new MyPrincipal("foo");
    }
}

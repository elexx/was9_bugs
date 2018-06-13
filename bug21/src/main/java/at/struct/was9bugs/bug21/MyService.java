package at.struct.was9bugs.bug21;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MyService {

    @Inject private MyPrincipal user;

    public void removeUnusedEntries() {
        System.out.println("Called remove for user: " + user.getName());
    }
}

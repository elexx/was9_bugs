package at.struct.was9bugs.bug8;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DelegatingService {
    private @Inject MyService service;

    public String name() {
        return service.name();
    }
}

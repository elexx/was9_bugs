package at.struct.was9bugs.bug8;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ApplicationService {

    private @Inject DelegatingService service;

    public String getName() {
        return service.name();
    }
}

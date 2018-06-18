package at.struct.was9bugs.bug21;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@Dependent
public class BoomBastic {

    private @Inject MyPrincipal principal;

    @PostConstruct
    public void init() {
        System.out.println("doing the init stuff for user " + principal.getName());
    }

    public int getMeaningOfLife() {
        return 42;
    }
}

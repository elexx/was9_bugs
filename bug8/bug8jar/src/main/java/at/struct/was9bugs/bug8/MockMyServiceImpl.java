package at.struct.was9bugs.bug8;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import java.util.logging.Level;
import java.util.logging.Logger;

@Dependent
@Alternative
public class MockMyServiceImpl implements MyService {
    private static final Logger log = Logger.getLogger(MockMyServiceImpl.class.getName());

    @Override
    public String name() {
        log.log(Level.INFO, "got called");
        return getClass().getCanonicalName();
    }
}

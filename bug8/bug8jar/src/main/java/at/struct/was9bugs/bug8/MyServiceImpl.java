package at.struct.was9bugs.bug8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;

@Dependent
public class MyServiceImpl implements MyService {
    private static final Logger log = LoggerFactory.getLogger(MockMyServiceImpl.class);

    @Override
    public String name() {
        log.info("got called");
        return getClass().getCanonicalName();
    }
}

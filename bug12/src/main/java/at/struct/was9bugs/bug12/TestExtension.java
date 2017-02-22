package at.struct.was9bugs.bug12;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExtension implements Extension {
    private static final Logger log = Logger.getLogger(TestExtension.class.getName());

    public void crashit(@Observes BeforeBeanDiscovery event) {
        log.log(Level.INFO, "TCCL is: {0}, class.getClassLoader is: {1}", new Object[]{
                Thread.currentThread().getContextClassLoader(),
                getClass().getClassLoader()
        });

        ClassNotFoundException firstFailure = null;

        // Let's try to load our own class!
        try {
            Class.forName(TestExtension.class.getCanonicalName(), false, Thread.currentThread().getContextClassLoader());
        }
        catch (ClassNotFoundException e) {
            log.log(Level.SEVERE, "Loading of TestExtension failed", e);
            firstFailure = e;
        }

        // Let's try to load some app class!
        try {
            Class.forName(SomeBean.class.getCanonicalName(), false, Thread.currentThread().getContextClassLoader());
        }
        catch (ClassNotFoundException e) {
            log.log(Level.SEVERE, "Loading of SomeBean failed", e);
            firstFailure = firstFailure == null ? e : firstFailure;
        }

        if (firstFailure != null) {
            throw new RuntimeException(firstFailure);
        }
    }
}

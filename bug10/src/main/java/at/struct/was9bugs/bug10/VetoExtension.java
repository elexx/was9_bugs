package at.struct.was9bugs.bug10;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

public class VetoExtension implements Extension {

    public void veto(@Observes ProcessAnnotatedType<MyEJB> pat) {
        pat.veto();
    }
}

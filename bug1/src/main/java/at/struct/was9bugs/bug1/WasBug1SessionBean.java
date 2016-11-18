package at.struct.was9bugs.bug1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named("wasBug1SessionBean")
public class WasBug1SessionBean implements Serializable {

    private @Inject WasBug1ApplicationService service;

    @PostConstruct
    public void initialize() {
        System.out.println("session created");
    }

    @PreDestroy
    public void sessionDestroyed() {
        System.out.println("session destroying");
        service.doSomething();
    }
}

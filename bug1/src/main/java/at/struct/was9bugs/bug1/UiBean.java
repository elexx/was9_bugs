package at.struct.was9bugs.bug1;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named("bean")
public class UiBean implements Serializable {

    private @Inject MyServiceInterface service;

    public String getData() {
        return service.doSomething();
    }
}

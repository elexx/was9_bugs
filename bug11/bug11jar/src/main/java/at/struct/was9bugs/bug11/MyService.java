package at.struct.was9bugs.bug11;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class MyService {

    // For the sake of demonstration, let's try to change this value on @Initialized(ApplicationScope.class) see MyAutostartService
    private String someValue = "unchanged default value";

    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }
}

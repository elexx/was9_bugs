package at.struct.was9bugs.bug1;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService implements MyServiceInterface {

    @Override
    public String doSomething() {
        return "Normal Service";
    }
}

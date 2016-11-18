package at.struct.was9bugs.bug1;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WasBug1ApplicationService {

    public void doSomething() {
        System.out.println("Doing Something!");
    }
}

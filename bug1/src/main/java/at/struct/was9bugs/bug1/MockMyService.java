package at.struct.was9bugs.bug1;

import org.apache.deltaspike.core.api.exclude.Exclude;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
@Exclude
public class MockMyService implements MyServiceInterface {

    @Override
    public String doSomething() {
        return "Mock Service";
    }
}

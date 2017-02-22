package at.struct.was9bugs.bug13;

import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class SomeBean {

    public void test(@Observes @Initialized(ApplicationScoped.class) Object o) {
        StringUtils.isNoneBlank("");
    }

}

package at.struct.was9bugs.bug13;

import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.validation.Validator;

@ApplicationScoped
public class SomeBean {

    private @Inject Validator validator;

    public void test(@Observes @Initialized(ApplicationScoped.class) Object o) {
        // This crashes the PARENT_FIRST CL
        StringUtils.isNoneBlank("");

        // And this crashes the PARENT_LAST CL
        validator.validateValue(CarBean.class, "manufacterer", null);
    }

}

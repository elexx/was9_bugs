package at.struct.was9bugs.bug21;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class UserSessionData implements Serializable {

    // this bean holds some data set and used by the user. the data is irrelevant for this demonstration
    private String value;

    @Inject private MyService service;

    @PostConstruct
    public void postConstruct() {
        value = "SomeValue";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @PreDestroy
    public void preDestroy() {
        try {
            service.removeUnusedEntries();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

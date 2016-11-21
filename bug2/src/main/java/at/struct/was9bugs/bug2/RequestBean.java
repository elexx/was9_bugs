package at.struct.was9bugs.bug2;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class RequestBean {
    private @Inject MyService service;

    public List<Object[]> getStat() {
        service.fillDB();
        return service.query();
    }
}

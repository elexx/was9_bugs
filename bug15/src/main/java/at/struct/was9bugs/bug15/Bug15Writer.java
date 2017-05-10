package at.struct.was9bugs.bug15;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class Bug15Writer extends AbstractItemWriter {

    private static final Logger log = Logger.getLogger(Bug15Reader.class.getName());

    @Inject
    @BatchProperty(name = "myBoolean")
    private Boolean myBoolean;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        log.log(Level.INFO, "Boolean is: " + myBoolean);

        for (Object item : items) {
            log.log(Level.INFO, "Got some item: " + item);
        }
    }
}

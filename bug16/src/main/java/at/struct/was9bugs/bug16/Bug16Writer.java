package at.struct.was9bugs.bug16;

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
public class Bug16Writer extends AbstractItemWriter {

    private static final Logger log = Logger.getLogger(Bug16Writer.class.getName());

    @Inject
    @BatchProperty(name = "param1")
    private String param1;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        log.log(Level.INFO, "param1 is: " + param1);

        for (Object item : items) {
            log.log(Level.INFO, "Got some item: " + item);
        }
    }
}

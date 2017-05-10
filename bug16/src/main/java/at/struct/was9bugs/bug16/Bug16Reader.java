package at.struct.was9bugs.bug16;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class Bug16Reader extends AbstractItemReader {

    private static final Logger log = Logger.getLogger(Bug16Reader.class.getName());

    @Inject
    @BatchProperty(name = "param1")
    private String param1;

    @Override
    public Object readItem() throws Exception {
        if (param1.equals("go")) {
            param1 = "stop";
            log.log(Level.INFO, "param1 was go, returning an item.");
            return "Some Value";
        }
        else {
            log.log(Level.INFO, "param1 was not go, quitting.");
            return null; // no more items to read
        }
    }
}

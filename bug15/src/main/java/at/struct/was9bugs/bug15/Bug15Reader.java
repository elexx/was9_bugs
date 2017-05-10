package at.struct.was9bugs.bug15;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class Bug15Reader extends AbstractItemReader {

    private static final Logger log = Logger.getLogger(Bug15Reader.class.getName());

    @Inject
    @BatchProperty(name = "myBoolean")
    private Boolean myBoolean;

    @Override
    public Object readItem() throws Exception {
        if (myBoolean) {
            myBoolean = false;
            log.log(Level.INFO, "myBoolean was true, returning an item.");
            return "Was true";
        }
        else {
            log.log(Level.INFO, "myBoolean was false, quitting.");
            return null; // no more items to read
        }
    }
}

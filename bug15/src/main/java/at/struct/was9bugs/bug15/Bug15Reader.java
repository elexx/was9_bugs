package at.struct.was9bugs.bug15;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class Bug15Reader extends AbstractItemReader {

    private static final Logger log = Logger.getLogger(Bug15Reader.class.getName());

    @Inject
    @BatchProperty(name = "myBoolean")
    private Boolean myBoolean;

    @Inject
    @BatchProperty(name = "myLong")
    private Long myLong;

    @Inject
    @BatchProperty(name = "myInteger")
    private Integer myInteger;

    @Inject
    @BatchProperty(name = "myString")
    private String myString;

    @Inject
    @BatchProperty(name = "myDate")
    private Date myDate;

    @Override
    public Object readItem() throws Exception {
        if (myBoolean) {
            log.log(Level.INFO, "Returning an item.");
            log.log(Level.INFO, "boolean: {0}, long: {1}, integer: {2}, string: {3}, date: {4}", new Object[]{myBoolean, myLong, myInteger, myString, myDate});
            myBoolean = false;
            return "Was true";
        }
        else {
            log.log(Level.INFO, "myBoolean was false, quitting.");
            return null; // no more items to read
        }
    }
}

package at.struct.was9bugs.bug15;

import at.struct.was9bugs.ContainerTest;
import org.apache.batchee.util.Batches;
import org.testng.annotations.Test;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class Bug15ReaderTest extends ContainerTest {

    @Test
    public void readerTest() throws Exception {
        JobOperator jobOperator = BatchRuntime.getJobOperator();

        Properties jobParameters = new Properties();
        jobParameters.put("myBoolean", "true");

        long jobId = jobOperator.start("bug15batch", jobParameters);
        Batches.waitForEnd(jobOperator, jobId);

        JobExecution jobExecution = jobOperator.getJobExecution(jobId);
        assertEquals(jobExecution.getBatchStatus(), BatchStatus.COMPLETED);
    }
}

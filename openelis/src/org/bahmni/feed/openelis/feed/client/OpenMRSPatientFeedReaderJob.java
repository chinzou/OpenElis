package org.bahmni.feed.openelis.feed.client;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class OpenMRSPatientFeedReaderJob extends OpenMRSFeedReaderJob {
    private static Logger logger = Logger.getLogger(OpenMRSPatientFeedReaderJob.class);

    public OpenMRSPatientFeedReaderJob() {
        super(logger);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            atomFeedClient.processEvents();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
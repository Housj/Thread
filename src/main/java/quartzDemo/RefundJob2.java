package quartzDemo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author sergei
 * @create 2020-03-19
 */
public class RefundJob2 implements Job {

//    public static void main(String[] args) throws JobExecutionException {
//        RefundJob2 refundJob = new RefundJob2();
//        refundJob.execute(null);
//    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("test2");
    }

}

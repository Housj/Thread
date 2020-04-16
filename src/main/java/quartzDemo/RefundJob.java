package quartzDemo;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.text.SimpleDateFormat;

/**
 * @author sergei
 * @create 2020-03-19
 */
@DisallowConcurrentExecution
public class RefundJob implements Job {

//    public static void main(String[] args) throws JobExecutionException {
//        RefundJob refundJob = new RefundJob();
//        refundJob.execute(null);
//    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println( sdf.format(System.currentTimeMillis()));
        try {
            Thread.sleep(3000);
            System.out.println("test");
            System.out.println( sdf.format(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

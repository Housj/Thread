package quartzDemo;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author sergei
 * @create 2020-03-19
 */
@Slf4j
public class JobMain {

    public static void main(String[] args) {
        JobMain jobMain = new JobMain();
        try {
            jobMain.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        // 还款任务
        if ("1".equals(PropertiesUtil.get("refundIsExcute"))) {
            String refundCronExpression = PropertiesUtil.get("refundCronExpression");
            String refundTrigger = PropertiesUtil.get("refundTrigger");
            String refundGroup = PropertiesUtil.get("refundGroup");
            String refundClass = PropertiesUtil.get("refundClass");
            JobDetail refundJob = JobBuilder.newJob(((Job) Class.forName(refundClass).newInstance()).getClass())
                    .withIdentity(refundTrigger, refundGroup).build();


            CronTrigger refundCronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
                    .withIdentity(refundTrigger, refundGroup)
                    .withSchedule(CronScheduleBuilder.cronSchedule(refundCronExpression)).build();

            scheduler.scheduleJob(refundJob, refundCronTrigger);

            log.info(refundJob.getKey()+"---------------------------------prepared");

        }

        // 还款任务
        if ("1".equals(PropertiesUtil.get("refundIsExcute2"))) {
            String refundCronExpression = PropertiesUtil.get("refundCronExpression2");
            String refundClass = PropertiesUtil.get("refundClass2");
            String refundTrigger = PropertiesUtil.get("refundTrigger2");
            String refundGroup = PropertiesUtil.get("refundGroup");
            JobDetail refundJob = JobBuilder.newJob(((Job) Class.forName(refundClass).newInstance()).getClass())
                    .withIdentity(refundTrigger, refundGroup).build();

            //不能存储同名的 CronTrigger 无法存储作业：“refundGroup.refundTrigger”
            CronTrigger refundCronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
                    .withIdentity(refundTrigger, refundGroup)
                    .withSchedule(CronScheduleBuilder.cronSchedule(refundCronExpression)).build();

            scheduler.scheduleJob(refundJob, refundCronTrigger);

        }

        scheduler.start();
        while (true){
            Thread.sleep(10);
        }
    }
}

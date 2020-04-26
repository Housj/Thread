package hotswap;


import java.lang.reflect.Method;

/**
 * @author sergei
 * @create 2020-04-21
 */
public class WatchDog implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }

//    private Map<String, FileDefine> fileDefineMap;
//
//    public WatchDog(Map<String, FileDefine> fileDefineMap) {
//        this.fileDefineMap = fileDefineMap;
//    }
//
//    @Override
//    public void run() {
//        File file = new File(FileDefine.WATCH_PACKAGE);
//        File[] files = file.listFiles();
//        for (File watchFile : files) {
//            long newTime = watchFile.lastModified();
//            FileDefine fileDefine = fileDefineMap.get(watchFile.getName());
//            long oldTime = fileDefine.getLastDefine();
//            //如果文件被修改了,那么重新生成累加载器加载新文件
//            if (newTime != oldTime) {
//                fileDefine.setLastDefine(newTime);
//                loadMyClass();
//            }
//        }
//    }
//
//    public void loadMyClass() {
//        try {
//            CustomClassLoader customClassLoader = new CustomClassLoader();
//            Class<?> cls = customClassLoader.loadClass("com.example.watchfile.Test", false);
//            Object test = cls.newInstance();
//            Method method = cls.getMethod("test");
//            method.invoke(test);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
package mvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

public class Application {

    public static void run() throws LifecycleException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(80);
        Context context = tomcat.addContext("/",App.class.getResource("/").getPath());

        context.addLifecycleListener((LifecycleListener)Class.forName(tomcat.getHost().getConfigClass()).newInstance());
        tomcat.start();
        tomcat.getServer().await();
    }
}

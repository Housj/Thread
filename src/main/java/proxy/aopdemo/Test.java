package proxy.aopdemo;

/**
 * @author sergei
 * @create 2020-02-17
 */
public class Test {
    public static void main(String[] args) {
        CarService carService = new CarServiceImpl();
        CarService proxy = (CarService) ProxyBean.getProxyBean(carService,new MyInterceptor());
        proxy.runCar("Test");
    }
}

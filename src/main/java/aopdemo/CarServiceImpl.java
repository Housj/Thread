package aopdemo;

/**
 * @author sergei
 * @create 2020-02-17
 */
public class CarServiceImpl implements CarService {
    @Override
    public void runCar(String carName) {
        if (carName == null || "".equals(carName)){
            throw new RuntimeException("carName is null");
        }
        System.out.println("Run"+carName);
    }
}

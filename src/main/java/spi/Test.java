package spi;

import java.util.ServiceLoader;

/**
 * @author sergei
 * @create 2020-05-01
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<Person> persons = ServiceLoader.load(Person.class);
        for (Person person : persons) {
            person.sou();
        }
    }
}

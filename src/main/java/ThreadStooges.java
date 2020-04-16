import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sergei
 * @create 2019-12-02
 */
@Immutable
public final class ThreadStooges {

    private final Set<String> stooges = new HashSet<String>();
    public ThreadStooges(){
        stooges.add("aaa");
        stooges.add("bbb");
        stooges.add("ccc");
    }

    public boolean isStooge(String name){
        return stooges.contains(name);
    }
}

package test2;

import java.util.List;
import java.util.Map;

/**
 * @author sergei
 * @create 2020-03-25
 */
public class test extends Thread {

    public static void main(String[] args) {
        test a = new test();
        a.run();
        a.start();

    }

//    @Override
//    public void run() {
//        super.run();
//        System.out.println("2");
//    }
    @Override
    public void start(){
        System.out.println("11");
    }

    public List<Map<String,Object>> mergeList(List<Map<String,Object>> list1,List<Map<String,Object>> list2,String filName){
        int index = 0;
        for (int i = 0,length =list1.size();i < length; i++) {
            if (list1.get(i).get("商品名称").equals(filName)){
                index = i;
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).get("商品id").equals(list1.get(index).get("商品id"))) {
                list1.get(index).putAll(list2.get(i));
            }
        }

        return list1;
    }
}

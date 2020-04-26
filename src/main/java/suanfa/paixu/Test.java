package suanfa.paixu;

/**
 * @author sergei
 * @create 2020-04-21
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {10,2,3,7,3,6,4};
//        maopao.sort(arr);
//        maopao.sortyouhua(arr);

//          xuanze.sort(arr);

//          charu.sort(arr);

//        kuaisu.sort(arr,0,6);

//        guibing.sort(arr,0,6);

//            xier.shellSort(arr);
//
//        dui.sort(arr);

        jishu.radixSort(arr);
//
        for (int a:arr) System.out.print(a+",");



    }
}

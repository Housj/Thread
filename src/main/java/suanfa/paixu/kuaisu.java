package suanfa.paixu;

/**
 * 快速排序基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * @author sergei
 * @create 2020-04-21
 */
public class kuaisu {

    //在数组中找一个支点(任意),经过一趟排序后，支点左边的数都要比支点小，支点右边的数都要比支点大！
    public static void sort(int[] arr,int L,int R){
        int i = L;//数组中第一个元素
        int j = R; //数组汇总最后一个元素
        int point = arr[(L+R)/2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i<=j){
            //寻找直到比支点大的数
            while (point>arr[i])
                i++;
            //寻找直到比支点小的数
            while (point<arr[j])
                j--;
            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            if (L<j) sort(arr,L,j);
            if (i<R) sort(arr,i,R);
        }

    }
}

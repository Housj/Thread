package suanfa.paixu;

/**
 * 插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据，
 * 算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
 * @author sergei
 * @create 2020-04-21
 */
public class charu {

    public static void sort(int[] arr){
        int temp;
        for (int i=1;i<arr.length;i++){
            temp = arr[i];
            //如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较
            int j = i-1;
            //arr[j]如果大于i，把i=j，然后循环j--,找j之前的值大于i的，并替换
            while ( j>=0 && arr[j] >temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=temp;
        }

        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}

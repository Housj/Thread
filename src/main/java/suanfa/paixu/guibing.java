package suanfa.paixu;

/**
 *
 * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 * @author sergei
 * @create 2020-04-21
 */
public class guibing {

       public static void sort(int[] arr,int L,int R){
           //如果只有一个元素，那就不用排序了
           if (L == R) {
               return;
           } else {
               //取中间的数，进行拆分
               int M = (L + R) / 2;
               //左边的数不断进行拆分
               sort(arr, L, M);
               //右边的数不断进行拆分
               sort(arr, M + 1, R);
               //合并
               merge(arr, L, M + 1, R);
           }
       }
    /**
     * 合并数组
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param M      指向数组分隔的元素
     * @param R      指向数组最后的元素
     */
    public static void merge(int[] arrays, int L, int M, int R) {
        //左边的数组的大小
        int[] leftArray = new int[M - L];
        //右边的数组大小
        int[] rightArray = new int[R - M + 1];
        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }
        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;
        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {
            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];
                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];
            k++;
            j++;
        }
    }
}
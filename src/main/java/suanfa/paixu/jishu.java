package suanfa.paixu;

/**
 * 基数排序(radix sort)属于"分配式排序"(distribution sort)，又称"桶子法"(bucket sort)或bin sort，
 * 顾名思义，它是透过键值的部份资讯，将要排序的元素分配至某些"桶"中，藉以达到排序的作用，基数排序法是属于稳定性的排序，
 * 其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 * @author sergei
 * @create 2020-04-21
 */
public class jishu {

    public static void radixSort(int[] arrays) {
        int max = findMax(arrays, 0, arrays.length - 1);
        //需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {
            int[][] buckets = new int[arrays.length][10];
            //获取每一位数字(个、十、百、千位...分配到桶子里)
            for (int j = 0; j < arrays.length; j++) {
                int num = (arrays[j] / i) % 10;
                //将其放入桶子里
                buckets[j][num] = arrays[j];
            }
            //回收桶子里的元素
            int k = 0;
            //有10个桶子
            for (int j = 0; j < 10; j++) {
                //对每个桶子里的元素进行回收
                for (int l = 0; l < arrays.length; l++) {
                    //如果桶子里面有元素就回收(数据初始化会为0)
                    if (buckets[l][j] != 0) {
                        arrays[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    /**
     * 递归，找出数组最大值
     * @param arr   数组
     * @param L     左边界，第一个数
     * @param R     右边界，数组的长度
     * @return
     */
    public static int findMax(int[] arr,int L,int R){
        if (L == R){
            return arr[L];
        }else{
            int a = arr[L];
            int b = findMax(arr,L+1,R);
            if (a > b){
                return a;
            } else {
                return b;
            }
        }
    }
}

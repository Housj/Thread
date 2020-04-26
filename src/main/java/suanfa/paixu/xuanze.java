package suanfa.paixu;

/**
 * 选择排序(Selection sort)是一种简单直观的排序算法。它的工作原理是每一次从待排序的数据元素中选出最小(或最大)的一个元素，
 * 存放在序列的起始(末尾)位置，直到全部待排序的数据元素排完。选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）
 *
 * 判断某排序算法是否稳定，我们可以简单理解成：排序前2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同
 * 如果相同，则是稳定的排序方法。  冒泡排序是稳定的，主要原因是：俩俩比较的时候，没有对相等的数据进行交换(因为没必要)
 * 如果不相同，则是不稳定的排序方法
 * @author sergei
 * @create 2020-04-21
 */
public class xuanze {

    public static void sort(int[] arr){
        //当前最大数的下标
        int pos;
        //当前最大的值
        int temp;
        //外层循环是排序的趟数
        for (int i=0;i<arr.length-1;i++){
            pos = 0;
            //内层循环控制遍历数组的个数并得到最大数的角标
            for (int j=0;j<arr.length-i;j++){
                if (arr[j] > arr[pos]){
                    pos = j;
                }
            }
            //交换
            temp = arr[pos];
            //把当前的最大值 和 数组排序的次数-1的下标交换，后面的已经排好序了
            arr[pos] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }

        for (int i : arr) {
            System.out.print(i+",");
        }
    }

    //同时找到最大值和最小值，分别插入尾部和首部
}

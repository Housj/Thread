package suanfa.paixu;

/**
 *  堆排序(Heapsort)是指利用堆积树（堆）这种数据结构所设计的一种排序算法，它是选择排序的一种。
 *  可以利用数组的特点快速定位指定索引的元素。堆分为大根堆和小根堆，是完全二叉树。
 *
 * 堆排序是将数据看成是完全二叉树、根据完全二叉树的特性来进行排序的一种算法
 *
 * 最大堆要求节点的元素都要不小于其孩子，最小堆要求节点元素都不大于其左右孩子
 * 那么处于最大堆的根节点的元素一定是这个堆中的最大值
 *
 * @author sergei
 * @create 2020-04-21
 */
public class dui {

    public static void sort(int[] arr){
        int tail= arr.length -1,size = tail;

        maxHeapify(arr,size);
        for (int i=0;i<tail+1;i++){
            int temp = arr[0];
            arr[0] = arr[tail-i];
            arr[tail-i] = temp;
            heapify(arr,0,size);
            size --;
        }

    }

    /**
     *  完成一次建堆，最大值在堆的顶部(跟节点)
     * @param arr
     * @param size
     */
    private static void maxHeapify(int[] arr, int size) {
        for (int i = size-1;i>=0;i--){
            heapify(arr,i,size);
        }
    }

    /**
     *
     * @param arr   完全二叉树
     * @param i     当前父节点
     * @param size  节点总数
     */
    private static void heapify(int[] arr, int i, int size) {
        if (i < size){
            //左子树和右子树的位置
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max = i;

            if (left < size){
                if (arr[max] < arr[left]){
                    max  = left;
                }
            }
            if (right < size){
                if (arr[max] < arr[right]){
                    max  = right;
                }
            }
            if(max != i){
                int temp = arr[max];
                arr[max] = arr[i];
                arr[i] = temp;
                heapify(arr,max,size);
            }
        }



    }


}

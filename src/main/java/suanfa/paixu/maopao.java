package suanfa.paixu;

/**
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端，故名。
 * @author sergei
 * @create 2020-04-21
 */
public class maopao {

    public static void sort(int[] arr){
        int temp;
        //外层循环是排序的趟数
        for (int i=0;i<arr.length;i++){
            //内层循环是当前趟数需要比较的次数
            for (int j=0;j<arr.length-i-1;j++){
                //前一位与后一位与前一位比较，如果前一位比后一位要大，那么交换
                if (arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i+",");
        }
    }

    //如果在某躺排序中没有发生交换位置，那么我们可以认为该数组已经排好序了
    public static void sortyouhua(int[] arr){
        int temp;
        int isChange;
        for (int i=0;i<arr.length;i++){
            isChange = 0;
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            //如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
            if (isChange == 0){
                break;
            }
        }
        for (int i : arr) {
            System.out.print(i+",");
        }
    }

}

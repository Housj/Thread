package suanfa.paixu;

/**
 * 希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
 * 是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法。
 *
 * 就是把数列进行分组(不停使用插入排序)，直至从宏观上看起来有序，最后插入排序起来就容易了(无须多次移位或交换)。
 * @author sergei
 * @create 2020-04-21
 */
public class xier {

    public static void shellSort(int[] arrays) {

        for (int step = arrays.length/2;step>0;step/=2){
            for (int i=step;i<arrays.length;i++){
                int j=i;
                int temp = arrays[j];
                while (j-step>=0 && arrays[j-step]>temp){
                    arrays[j] = arrays[j-step];
                    j = j-step;
                }
                arrays[j] = temp;
            }
        }
    }
}

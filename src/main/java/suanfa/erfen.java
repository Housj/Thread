package suanfa;

/**
 * @author sergei
 * @create 2020-03-22
 */
public class erfen {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10,11};

        int index = 8;
        System.out.println(a[search(a,index)]);
    }

    public static int search(int[] arr,int index){
        int di = 0,gao=arr.length-1;
        while (di <= gao){
            int zhong = di+(gao-di)/2;
            if (arr[zhong] == index){
                return zhong;
            }else if (arr[zhong] < index){
                di = zhong+1;   //如果中位数小于index，那把低位=中位数 加1，可能index=中位数+1
            }else if (arr[zhong] > index){
                gao = zhong-1;  //如果中位数大于index，那把高位=中位数 -1，可能index=中位数-1
            }
        }
        return -1;
    }
}

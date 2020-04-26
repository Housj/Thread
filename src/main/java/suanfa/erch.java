package suanfa;

/**
 * @author sergei
 * @create 2020-04-21
 */
public class erch {

    int data;
    erch left;
    erch right;

    public erch(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insert(erch root,int data){
        if (root.data > data){
            if(root.left != null){
                insert(root.left,data);
            }else {
                root.left = new erch(data);
            }
        }else {
            if(root.right != null){
                insert(root.right,data);
            }else {
                root.right = new erch(data);
            }
        }
    }

    public void in(erch root){
        if (root!=null){
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }
    }

    public static void main(String[] args) {
        Integer[] s = {1,2,4,8,9,3,5};
        erch e = new erch(10);
        for (Integer i : s) {
            e.insert(e,i);
        }
        e.in(e);
    }
}

package test;

import java.util.PriorityQueue;

/**
 * @author sergei
 * @create 2020-02-12
 */
public class priorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
        q.add("c");
        q.add("b");
        q.add("a");
        q.add("d");

        for (int i=0;i<5;i++){
            System.out.println(q.poll());
        }
    }
}

package suanfa.LRU;


import java.util.HashMap;

/**
 * @author sergei
 * @create 2020-02-21
 */
public class LRUDemo {

    public static void main(String[] args) {

        LRU<Integer,String> l = new LRU<Integer, String>(5);
        l.put(1,"a");
        l.put(2,"b");
        l.put(3,"c");
        l.put(4,"d");
        l.put(5,"e");


        System.out.println(l.toString());
        l.put(2,"r");
        System.out.println(l.toString());
        l.put(6,"t");
        l.put(8,"i");
        System.out.println(l.toString());
        l.get(4);
        l.get(5);
        System.out.println(l.toString());
        System.out.println(l.currentSize);
        System.out.println(l.capcity);

    }



    static class LRU<K,V>{
        private int currentSize;//当前大小
        private int capcity;//总容量
        private HashMap<K,Node> caches;
        private Node first;
        private Node last;

        public LRU(int size){
            currentSize = 0;
            this.capcity = size;
            caches = new HashMap<K,Node>(size);
        }

        Object get(K key){
            Node node = caches.get(key);
            if (node != null){
                mveToHead(node);
                return node.value;
            }
            return null;
        }

        void put(K key,Object o){
            Node node = caches.get(key);
            if (node == null){
                if (currentSize == capcity){
                    removeLast();
                }
                node = new Node(key,o);
            }
            remove((K) node.key);
            if (last == null){
                last = node;
            }
            node.value = o;
            mveToHead(node);
            caches.put(key,node);
            currentSize++;
        }

        void mveToHead(Node node){
            if (first == node) {
                return;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node == last) {
                last = last.pre;
            }
            if (first == null || last == null) {
                first = last = node;
                return;
            }
            node.next = first;
            first.pre = node;
            first = node;
            first.pre = null;
        }

        void removeLast(){
            if (last != null){
                last = last.pre;
                last.next = null;
                currentSize--;
             }
            if (last == null){
                first = null;
            }
        }

        void remove(K key){
            if (currentSize > 0){
                Node node  = caches.get(key);
                if (node !=null){
                    if (node.pre != null){
                        node.pre.next = node.next;
                    }
                    if (node.next != null){
                        node.next.pre = node.pre;
                    }
                    if (node == first){
                        first = node.next;
                    }
                    if (node == last){
                        last = node.pre;
                    }
                    currentSize --;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node node = first;
            while (node != null) {
                sb.append(String.format("%s:%s ", node.key, node.value));
                node = node.next;
            }
            sb.append("first="+first.key+":"+first.value+"  ");
            sb.append("last="+last.key+":"+last.value);
            return sb.toString();
        }
    }
    static class Node{
        Object key;
        Object value;
        Node pre;
        Node next;
        public Node(Object key,Object value){
            this.key = key;
            this.value = value;
        }
    }
}

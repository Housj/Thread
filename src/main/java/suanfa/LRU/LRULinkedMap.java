package suanfa.LRU;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class LRULinkedMap<T,V> {
    /**
     * 最大缓存大小
     */
    private int cacheSize;

    private LinkedHashMap<String, Integer> cacheMap;

    public LRULinkedMap(int cacheSize){
        this.cacheSize = cacheSize;

        cacheMap = new LinkedHashMap(2, 0.75F, true){

            protected <Entry> boolean removeEldestEntry(Entry eldest) {
                if(cacheSize + 1 == cacheMap.size()){
                    return true;
                }else{
                    return false;
                }
            }
        };
    }

    public void put(String key, Integer value){
        cacheMap.put(key, value);
    }

    public Object get(Object key){
        return cacheMap.get(key);
    }

    public Collection<Map.Entry<String, Integer>> getAll(){
        return new ArrayList<Map.Entry<String, Integer>>(cacheMap.entrySet());
    }

    public static void main(String[] args) {
        LRULinkedMap<String, Integer> map = new LRULinkedMap<String,Integer>(3);
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key6", 6);

        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.println(e.getKey()+"====>"+e.getValue());
        }
        System.out.println("\n");
        map.put("key4", 4);
        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.println(e.getKey()+"====>"+e.getValue());
        }

    }

}

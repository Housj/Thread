package suanfa.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_CACHE_SIZE = 100;

    private int limit;

    public LRUCache() {
        this(MAX_CACHE_SIZE);
    }

    public LRUCache(int cacheSize) {
        super(cacheSize, 0.75f, true);//这里是true哟，所以访问的话也会被更新到末尾
        this.limit = cacheSize;
    }

    public V save(K key, V val) {
        return put(key, val);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    /**
     * 判断节点数是否超限
     * @param eldest
     * @return 超限返回 true，否则返回 false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > limit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        for (int i = 0; i < 10; i++) {
            cache.save("I" + i, i * i);
        }

        System.out.println("插入10个键值对后，缓存内容为：");
        System.out.println(cache + "\n");

        System.out.println("访问键值为I8的节点后，缓存内容为：");
        cache.getOne("I8");
        System.out.println(cache + "\n");

        System.out.println("插入键值为I1的键值对后，缓存内容：");
        cache.save("I1", 1);
        System.out.println(cache);
    }
}

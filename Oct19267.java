import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Oct19267 {

    public static void main(String[] args) {

    }

    class LRUCache {

        Map<Integer, Integer> cache = new HashMap<>();
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true)
            {
                @Override 
                public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest)
                {
                        return size()>LRUCache.this.capacity;
                }
            }
        }

        public int get(int key) {
            return this.cache.get(key);
        }

        public void put(int key, int value) {
            this.cache.put(key, value);
        }
    }

}

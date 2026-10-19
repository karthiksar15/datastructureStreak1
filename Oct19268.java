import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Oct19268 {

    public static void main(String[] args) {

    }

    class Node {
        private int key;
        private int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    class LRUCache {
        private final Map<Integer, Node> cache;
        private final int capacity;
        Node left;
        Node right;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.left = new Node(0, 0);
            this.right = new Node(0, 0);
            this.left.next = this.right;
            this.right.prev = this.left;
        }

        public void insert(int key, int value) {
            if (this.cache.containsKey(key)) {
                remove(key);
            }
            Node node = new Node(key, value);
            Node prev = this.right.prev;
            prev.next = node;
            node.next = this.right;
            node.prev = prev;
        }

        public void remove(int key) {
            if (cache.containsKey(key)) {
                Node node = this.cache.get(key);
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
            }
        }

        public int get(int key) {
        }

        public void put(int key, int value) {
            insert(key, value);
        }
    }

}

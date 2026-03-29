import java.util.LinkedList;

public class Mar29262 {

    class MyHashMap {
        private int SIZE = 10007;
        private LinkedList<Entry>[] list;

        public MyHashMap() {
            list = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                list[i] = new LinkedList<>();
            }
        }

        class Entry {
            private int key;
            private int val;

            public Entry(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public void add(Entry obj) {
            int hash = hash(obj.key);
            if (!contains(obj.key)) {
                list[hash].add(new Entry(obj.key, obj.val));
            }
        }

        public boolean contains(int key) {
            int hash = hash(key);
            for (Entry entry : list[hash]) {
                return entry.key == key;
            }
            return false;
        }

        public int hash(int val) {
            return val % SIZE;
        }
    }

}

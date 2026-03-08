import java.util.LinkedList;
import java.util.List;

public class Mar08261 {

    class Entry {
        public int key;
        public int val;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class Hashmap {

        private static int SIZE = 100007;
        public List<Entry>[] listNode;

        public Hashmap() {
            listNode = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                listNode[i] = new LinkedList<>(); // every index has an empty list
            }
        }

        public void put(int key, int value) {
            int hs = hash(key);
            for (Entry entry : listNode[hs]) {
                if (entry.key == key) {
                    entry.val = value; // update in one pass
                    return;
                }
            }
            listNode[hs].add(new Entry(key, value));
        }

        public int get(int key) {
            int hs = hash(key);
            if (listNode[hs] != null) {
                List<Entry> list = listNode[hs];
                for (Entry entry : list) {
                    if (entry.key == key)
                        return entry.val;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int hs = hash(key);
            if (!contains(key)) {
                List<Entry> list = listNode[hs];
                list.removeIf(v -> v.key == key);
            }
        }

        public boolean contains(int key) {
            int hs = hash(key);
            if (listNode[hs] != null) {
                List<Entry> list = listNode[hs];
                for (Entry entry : list) {
                    if (entry.key == key)
                        return true;
                }
            }
            return false;
        }

        public int hash(int key) {
            return (key % SIZE);
        }

    }

}

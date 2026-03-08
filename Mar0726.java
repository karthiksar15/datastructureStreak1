import java.util.LinkedList;
import java.util.List;

public class Mar0726 {

    class HashSet {
        List<String>[] list;
        private static int SIZE = 10007;

        public HashSet() {
            this.list = new LinkedList[SIZE];
        }

        public void add(String key) {
            int hVal = hashing(key);
            if (list[hVal] == null) {
                list[hVal] = new LinkedList<>();
            }
            list[hVal].add(key);
        }

        public boolean contains(String key) {
            int hashVal = hashing(key);
            return list[hashVal] != null;
        }

        public void remove(String key) {
            int hVal = hashing(key);
            if (list[hVal] != null)
                list[hVal].remove(key);
        }

        public int hashing(String key) {
            int h = 0;
            for (int i = 0; i < key.length(); i++) {
                h = (h * 31 + key.charAt(i)) % SIZE;
            }
            return h;
        }
    }

}

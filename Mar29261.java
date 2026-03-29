import java.util.LinkedList;

public class Mar29261 {

    class MyHashSet {

        private LinkedList<Integer>[] list;
        private int SIZE = 10007;

        public MyHashSet() {
            list = new LinkedList[SIZE];
            for (int i = 0; i < list.length; i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void addKey(int val) {
            int hash = hash(val);
            if (!contains(val))
                list[hash].add(val);

        }

        public boolean contains(int val) {
            int hash = hash(val);
            if (list[hash].contains(val))
                return true;
            else
                return false;
        }

        public int hash(int num) {
            return num % SIZE;
        }
    }

}

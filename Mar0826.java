public class Mar0826 {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class HashSet {
        ListNode[] map;
        private static int SIZE = 10000;

        public HashSet() {
            map = new ListNode[SIZE];
            for (int i = 0; i < SIZE; i++) {
                map[i] = new ListNode(-1);
            }
        }

        public void add(int key) {
            if (contains(key))
                return;
            int h = hash(key);
            ListNode list = map[h];
            while (list != null) {
                if (list.val == -1) {
                    list.val = key;
                    list.next = new ListNode(-1);
                    break;
                }
                list = list.next;
            }
        }

        public void remove(int key) {
            int h = hash(key);
            ListNode list = map[h];
            ListNode prev = null;
            while (list != null) {
                if (list.val == key) {
                    if (prev == null) {
                        map[h] = list.next;
                    } else {
                        prev.next = list.next;
                    }
                    break;
                }
                prev = list;
                list = list.next;
            }
        }

        public boolean contains(int key) {
            int h = hash(key);
            ListNode list = map[h];
            while (list != null) {
                if (list.val == key) {
                    return true;
                }
                list = list.next;
            }
            return false;
        }

        public int hash(int key) {
            return key % SIZE;
        }
    }

}

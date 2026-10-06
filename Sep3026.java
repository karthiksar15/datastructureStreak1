class Sep3026 {
    public static void main(String[] args) {
        MyCircularQueue my = new MyCircularQueue(3);
    }

    class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class MyCircularQueue {
        private ListNode left;
        private ListNode right;
        private int k;

        public MyCircularQueue(int k) {
            this.k = k;
            this.left = new ListNode(0);
            this.right = this.left;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;
            ListNode cur = new ListNode(value);
            if (isEmpty()) {
                this.left.next = cur;
                this.right = cur;
            }
            this.k--;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;
            this.left.next = this.left.next.next;
            if (this.left.next == null) {
                this.right = this.left;
            }
            this.k++;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : this.left.next.val;
        }

        public int Rear() {
            return isEmpty() ? -1 : this.right.val;
        }

        public boolean isEmpty() {
            return this.left.next == null;
        }

        public boolean isFull() {
            return this.k == 0;
        }
    }
}
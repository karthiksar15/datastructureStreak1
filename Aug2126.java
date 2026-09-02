class Aug2126 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Aug2126 aug = new Aug2126();
        Node node1 = aug.new Node(3);
        Node node2 = aug.new Node(7);
        Node node3 = aug.new Node(4);
        Node node4 = aug.new Node(5);
        node1.next = node2;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node1;
        node4.random = node2;
        Node newNode = aug.copyRandomList(node1);
        while (newNode != null) {
            System.out.println("val--->" + newNode.val);
            newNode = newNode.next;
        }
    }

    public Node copyRandomList(Node head) {
        Node l1 = head;
        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.random;
            l1.random = l2;
            l1 = l1.next;
        }
        Node newHead = head.random;
        l1 = head;
        while (l1 != null) {
            Node l2 = l1.random;
            l2.random = (l2.next != null) ? l2.next.random : null;
            l1 = l1.next;
        }
        l1 = head;
        while (l1 != null) {
            Node l2 = l1.random;
            l1.random = l2.next;
            l2.next = (l1.next != null) ? l1.next.random : null;
            l1 = l1.next;
        }
        return newHead;
    }
}

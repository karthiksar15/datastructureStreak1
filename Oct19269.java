public class Oct19269 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Oct19269 oct = new Oct19269();
        ListNode node1 = oct.new ListNode(1);
        ListNode node2 = oct.new ListNode(2);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(4);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(1);
        ListNode node5 = oct.new ListNode(3);
        node4.next = node5;
        ListNode node6 = oct.new ListNode(5);
        node5.next = node6;
        ListNode node7 = oct.new ListNode(3);
        ListNode node8 = oct.new ListNode(6);
        node7.next = node8;
        ListNode[] listNode = { node1, node4, node7 };
        oct.mergeKLists(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        for (int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i - 1], lists[i]);
        }
        return lists[n - 1];
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if (node1 != null) {
            curr.next = node1;
        } else {
            curr.next = node2;
        }
        return dummy.next;
    }

}

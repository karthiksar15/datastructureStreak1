public class Oct24267 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Oct24267 oct = new Oct24267();
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
        oct.mergeTwoLists(node1, node4);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }
        return res.next;
    }

}

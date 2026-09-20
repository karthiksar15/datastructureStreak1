class Sep2026 {

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
        Sep2026 sep = new Sep2026();
        ListNode l1 = sep.new ListNode(1);
        ListNode l2 = sep.new ListNode(2);
        l1.next = l2;
        ListNode l3 = sep.new ListNode(3);
        l2.next = l3;
        ListNode l4 = sep.new ListNode(4);
        ListNode l5 = sep.new ListNode(5);
        l4.next = l5;
        ListNode l6 = sep.new ListNode(6);
        l5.next = l6;
        ListNode result = sep.addTwoNumbers(l1, l4);
        while (result != null) {
            System.out.println("num-->" + result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode curr = start;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return start.next;
    }
}
class Oct1426 {

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
        Oct1426 oct = new Oct1426();
        ListNode list1 = oct.new ListNode(1);
        ListNode list2 = oct.new ListNode(2);
        list1.next = list2;
        ListNode list3 = oct.new ListNode(4);
        list2.next = list3;
        ListNode list4 = oct.new ListNode(1);
        ListNode list5 = oct.new ListNode(3);
        list4.next = list5;
        ListNode list6 = oct.new ListNode(5);
        list5.next = list6;
        ListNode list7 = oct.new ListNode(3);
        ListNode list8 = oct.new ListNode(6);
        list7.next = list8;

        ListNode merged = oct.mergeKLists(new ListNode[] { list1, list4, list7 });
        System.out.println("mergeKList--->");
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        for (int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i - 1], lists[i]);
        }
        return lists[lists.length - 1];
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return dummy.next;
    }
}
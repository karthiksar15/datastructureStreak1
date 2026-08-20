public class Aug1826 {

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
        Aug1826 aug = new Aug1826();
        ListNode listnode1 = aug.new ListNode(1);
        ListNode listnode2 = aug.new ListNode(2);
        listnode1.next = listnode2;
        ListNode listnode3 = aug.new ListNode(4);
        listnode2.next = listnode3;
        ListNode listnode11 = aug.new ListNode(1);
        ListNode listnode12 = aug.new ListNode(3);
        listnode11.next = listnode12;
        ListNode listnode13 = aug.new ListNode(5);
        listnode12.next = listnode13;
        ListNode output = aug.mergeTwoLists(listnode1, listnode11);
        while (output != null) {
            System.out.println("merged---");
            System.out.println(output.val);
            output = output.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode output = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                output.next = list1;
                list1 = list1.next;
            } else if (list2.val <= list1.val) {
                output.next = list2;
                list2 = list2.next;
            }
            output = output.next;
        }
        if (list1 != null)
            output.next = list1;
        if (list2 != null)
            output.next = list2;
        return dummy.next;
    }

}

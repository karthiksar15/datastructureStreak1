import java.util.HashSet;
import java.util.Set;

public class Aug20262 {

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
        Aug20262 aug = new Aug20262();
        ListNode node = aug.new ListNode(1);
        ListNode node1 = aug.new ListNode(2);
        node.next = node1;
        ListNode node2 = aug.new ListNode(3);
        node1.next = node2;
        ListNode node3 = aug.new ListNode(4);
        node2.next = node3;
        node3.next = node1;
        System.out.println("hasCycle--->" + aug.hasCycle(node));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode node = head;
        Set<Integer> set = new HashSet<>();
        while (node != null) {
            if (!set.add(node.val)) {
                break;
            }
            node = node.next;
        }
        if (node == null)
            return false;
        return true;
    }

}

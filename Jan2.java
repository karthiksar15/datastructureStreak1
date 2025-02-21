public class Jan2 {

    public static void main(String[] args) {
        NodeList NodeList1 = new NodeList(1);
        NodeList NodeList2 = new NodeList(2);
        NodeList1.next = NodeList2;
        NodeList NodeList3 = new NodeList(3);
        NodeList2.next = NodeList3;
        NodeList NodeList4 = new NodeList(4);
        NodeList3.next = NodeList4;
        NodeList NodeList5 = new NodeList(5);
        NodeList4.next = NodeList5;
        NodeList NodeList6 = new NodeList(6);
        NodeList5.next = NodeList6;
        System.out.println(findMiddle(NodeList1).val);

    }

    public static NodeList findMiddle(NodeList head) {
        NodeList slowPtr = head;
        NodeList fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

}

class NodeList {
    public Integer val;
    public NodeList next;

    public NodeList() {
    }

    public NodeList(Integer val) {
        this.val = val;
        this.next = null;
    }

    // @Override
    // public String toString() {
    // return new StringBuilder().append(String.valueOf(this.val)).toString();
    // }
}


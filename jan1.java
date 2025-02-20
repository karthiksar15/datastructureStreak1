
public class Jan1 {

    public static void main(String[] args) {

    }

}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public void addNode(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void deleteNode(Node prevNode) {
        prevNode.next = prevNode.next.next;
    }

}

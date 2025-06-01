public class Jan18 {

    public static void main(String[] args) {

        Jan18 jan = new Jan18();
        Node node1 = jan.new Node(3);
        Node node2 = jan.new Node(9);
        Node node3 = jan.new Node(20);
        Node node4 = jan.new Node(15);
        Node node5 = jan.new Node(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println("minimum depth--" + helper(node1));
    }

    public static int helper(Node node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }

    }

}


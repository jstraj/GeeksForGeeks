class RangeKeys {
    
    Node root;

    public void printRangeKeys(Node node, int n1, int n2) {
        
        if(node == null)
            return;

        if(node.data > n1)
            printRangeKeys(node.left, n1, n2);

        if(node.data <= n2 && node.data >= n1)
            System.out.print(node.data+" ");

        if(node.data < n2)
            printRangeKeys(node.right, n1, n2);
        
    }

    public static void main(String args[]) {
        RangeKeys tree = new RangeKeys();
        int k1 = 10, k2 = 25;
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
 
        tree.printRangeKeys(tree.root, k1, k2);
    }
}

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
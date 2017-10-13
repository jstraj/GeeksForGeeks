class LargestBST {
    
    Node root;

    public Info getLargestBST(Node root) {

        if(root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        if(root.left == null && root.right == null)
            return new Info(true, 1, root.data, root.data);

        Info l = getLargestBST(root.left);
        Info r = getLargestBST(root.right);

        Info ret = new Info();

        if(l.isBST && r.isBST && root.data > l.max && root.data < r.min) {
            ret.size = l.size + r.size + 1;
            ret.isBST = true;
            ret.min = Math.min(r.min, Math.min(l.min, root.data));
            ret.max = Math.max(r.max, Math.max(l.max, root.data));
            //System.out.println(root.data+": ("+ret.isBST+","+ret.size+","+ret.min+","+ret.max+")");
            return ret;
        }
        ret.isBST = false;
        ret.size = Math.max(l.size, r.size);
        //System.out.println(root.data+": ("+ret.isBST+","+ret.size+","+ret.min+","+ret.max+")");

        return ret;
    }
    
    public static void main(String args[]) {
        LargestBST tree = new LargestBST();
        
        tree.root = new Node(25);
        tree.root.left = new Node(18);
        tree.root.left.left = new Node(19);
        tree.root.left.right = new Node(20);
        tree.root.left.left.right = new Node(15);
        tree.root.left.right.left = new Node(18);
        tree.root.left.right.right = new Node(25);

        tree.root.right = new Node(50);
        tree.root.right.left = new Node(35);
        tree.root.right.right = new Node(60);
        tree.root.right.left.left = new Node(20);
        tree.root.right.left.right = new Node(40);
        tree.root.right.left.left.right = new Node(25);
        tree.root.right.right.left = new Node(55);
        tree.root.right.right.right = new Node(70);
        
        Info result = tree.getLargestBST(tree.root);
        System.out.println("The size of the Largest BST is: "+result.size);
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

class Info {
    boolean isBST;
    int size;
    int min;
    int max;

    public Info() {
        this.isBST = false;
        this.size = 0;
        this.min = 0;
        this.max = 0;
    }

    public Info(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}
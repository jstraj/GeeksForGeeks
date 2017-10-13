class KthLargest {
	
	Node root;
    int c = 0;  //this is a global variable because copies of k will be made so multiple results will follow

    public void findKthLargest(Node root, int k) {

        if(root == null || k <= 0)
            return;

        findKthLargest(root.right, k);

        c++;
        if(k == c) {
            System.out.println(root.data);
            return;
        }

        findKthLargest(root.left, k);
    }


	 // function to insert nodes
    public void insert(int data)
    {
        this.root = this.insertRec(this.root, data);
    }
     
    /* A utility function to insert a new node 
    with given key in BST */
    Node insertRec(Node node, int data)
    {   
        /* If the tree is empty, return a new node */
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }
 
        if (data == node.data) {
            return node;
        }
         
        /* Otherwise, recur down the tree */
        if (data < node.data) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    public void inorder(Node root) {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

	public static void main(String args[]) {
		KthLargest tree = new KthLargest();
		tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        //tree.inorder(tree.root); System.out.println();

        for (int i = 1; i <= 7; i++) {
            tree.c = 0;
            tree.findKthLargest(tree.root, i);
        }
	}
}

class Node {
	int data;
	Node left, right, parent;
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
}
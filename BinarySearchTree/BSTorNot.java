class BSTorNot {
	
	Node root;
	Node prev = null;

	public boolean isBST1(Node node, int min, int max) {
		
		if(node == null)
			return true;

		if(node.data < min || node.data > max)
			return false;

		return isBST1(node.left, min, node.data) && isBST1(node.right, node.data, max);
	}

	public boolean isBST2(Node root) {
		if(root != null) {
			if(!isBST2(root.left))
				return false;

			if(prev!=null && root.data <= prev.data)	/*left = no restriction, root > left, right > root..... BOTTOM UP*/
				return false;
			prev = root;
			return isBST2(root.right);
		}
		return true;
	}

	public static void main(String args[]) {
		BSTorNot tree = new BSTorNot();
		tree.root = new Node(8);
		tree.root.left = new Node(3);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(4);
		tree.root.left.right.right = new Node(7);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(13);

		if(tree.isBST1(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("The tree is a BST");
		else
			System.out.println("The tree is not a BST");

		if(tree.isBST2(tree.root))
			System.out.println("The tree is a BST");
		else
			System.out.println("The tree is not a BST");
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
class BST {
	
	Node root;

	public Node search(Node root, int key) {
		if(root == null)
			return null;

		if(root.data == key)
			return root;

		if(key > root.data)
			return search(root.right, key);

		return search(root.left, key);
	}

	public Node insert(Node root, int key) {

		if(root == null) {
			root = new Node(key);
			return root;
		}
		if(key<root.data)
			root.left = insert(root.left, key);
		else if(key>root.data)
			root.right = insert(root.right, key);

		return root;
	}

	public Node delete(Node root, int key) {
		if(root == null)
			return root;

		if(key<root.data)
			root.left = delete(root.left, key);
		else if(key>root.data)
			root.right = delete(root.right, key);
		else {
			//Node with only 1 or 0 child
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;

			//Node with 2 child: get inorder successor
			root.data = minValue(root.right);
			//Delete the inorder successor
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	public int minValue(Node root) {
		int minv = root.data;
		while(root.left!=null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	public void inorder(Node root) {

		if(root == null)
			return;

		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	public static void main(String args[]) {
		BST tree = new BST();
		tree.root = new Node(8);
		tree.root.left = new Node(3);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(4);
		tree.root.left.right.right = new Node(7);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(13);

		Node node = tree.search(tree.root, 14);
		if(node == null)
			System.out.println("Key not found");
		else
			System.out.println("Key is found");

		tree.insert(tree.root, 11);
		tree.delete(tree.root, 3);

		tree.inorder(tree.root);
		System.out.println();
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
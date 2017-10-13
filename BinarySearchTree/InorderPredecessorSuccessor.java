class InorderPredecessorSuccessor {
	
	Node root;
	Node pred, succ;

	public void findPredSucc(Node root, int key) {
		if(root == null)
			return;

		if(root.data == key) {

			//predecessor
			if(root.left != null) {
				Node temp = root.left;
				while(temp.right != null)
					temp = temp.right;
				pred = temp;
			}

			//successor
			if(root.right != null) {
				Node temp = root.right;
				while(temp.left != null)
					temp = temp.left;
				succ = temp;
			}
			return;
		}

		if(key < root.data) {
			succ = root;	//THE KEY WILL LIE IN THE RANGE (PRED, SUCC)
			findPredSucc(root.left, key);
		}
		else if(key > root.data) {
			pred = root;
			findPredSucc(root.right, key);
		}
	}

	public static void main(String args[]) {
		InorderPredecessorSuccessor tree = new InorderPredecessorSuccessor();
		tree.root = new Node(8);
		tree.root.left = new Node(3);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(4);
		tree.root.left.right.right = new Node(7);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(13);

		//Node pred = null, succ = null;
		tree.findPredSucc(tree.root, 12);
		System.out.println("predecessor: "+tree.pred.data);
		System.out.println("successor: "+tree.succ.data);
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
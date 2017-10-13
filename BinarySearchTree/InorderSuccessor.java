class InorderSuccessor {
	
	Node root;

	public Node inOrderSuccessor2(Node root, Node n) {

		if(n.right!=null)
			return minValue(n.right);

		Node succ = null;
		while(root!=null) {
			if(n.data < root.data) {
				succ = root;	//we save it as a successor if we move towards left
				root = root.left;
			} else if(n.data > root.data)
				root = root.right;
			else
				break;
		}
		return succ;
	}

	public Node inOrderSuccessor(Node root, Node n) {

		if(n.right != null)
			return minValue(n.right);

		Node p = n.parent;
		while(p!=null && n == p.right) {
			n = p;
			p = p.parent;
		}
		return p;
	}

	Node minValue(Node node) {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

	public Node insert(Node node, int data) {
 
        /* 1. If the tree is empty, return a new,     
         single node */
        if (node == null) {
            return (new Node(data));
        } else {
 
            Node temp = null;
             
            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
 
            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
 
            /* return the (unchanged) node pointer */
            return node;
        }
    }

	public static void main(String args[]) {
		InorderSuccessor tree = new InorderSuccessor();
		Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor2(root, temp);
        if (suc != null) {
            System.out.println("Inorder successor of " + temp.data + 
                                                      " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
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
import java.io.*;
import java.util.*;

class BinaryTree {
	
	Node root;
	public BinaryTree() {
		root = null;
	}

	public void preOrder(Node root) {
		if(root == null)
			return;

		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(Node root) {
		if(root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}

	public void inOrder(Node root) {
		if(root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}


	public void levelOrderTraversal(Node root) {

		if(root == null)
			return;

		Queue<Node> queue = new LinkedList();
		queue.offer(root);
		while(true) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			while(nodeCount>0) {
				Node node = queue.poll();
				System.out.print(node.data+" ");
				if(node.left!=null)
					queue.offer(node.left);
				if(node.right!=null)
					queue.offer(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}


	public void preOrderIterative(Node root) {
		if(root == null)
			return;

		Stack<Node> stack = new Stack();
		stack.push(root);
		while(!stack.empty()) {
			Node node = stack.pop();
			System.out.print(node.data+" ");
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
	}

	public void postOrderIterative(Node root) {
		if(root == null)
			return;

		Stack<Node> s1 = new Stack();
		Stack<Node> s2 = new Stack();
		s1.push(root);

		while(!s1.empty()) {
				Node node = s1.pop();
				if(node.left!=null)
					s1.push(node.left);
				if(node.right!=null)
					s1.push(node.right);
				s2.push(node);
		}

		while(!s2.empty()) {
			System.out.print(s2.pop().data+" ");
		}
	}

	public void inOrderIterative(Node root) {

		if(root == null)
			return;

		Stack<Node> stack = new Stack();
		Node node = root;

		while(node!=null) {
			stack.push(node);
			node = node.left;
		}

		while(stack.size() > 0) {
			node = stack.pop();
			System.out.print(node.data+" ");
			if(node.right!=null) {
				node = node.right;
				while(node!=null) {
					stack.push(node);
					node = node.left;
				}
			}

		}
	}

	public void reverseLevelOrder(Node root) {
		if(root == null)
			return;

		Stack<Node> stack = new Stack();
		Queue<Node> queue = new LinkedList();
		queue.offer(root);

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			stack.push(node);
			if(node.left!=null)
				queue.offer(node.left);
			if(node.right!=null)
				queue.offer(node.right);
		}

		while(!stack.empty())
			System.out.print(stack.pop().data+" ");
	}

	public void diagonalTraversal(Node root) {
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap();
		diagonalTraversalUtil(root, 0, map);
		for(Integer key: map.keySet()) {
			System.out.print(key+" : ");
			System.out.println(map.get(key));
		}
	}

	public void diagonalTraversalUtil(Node node, int d, HashMap<Integer, ArrayList<Integer>> map) {
		if(node == null)
			return;

		ArrayList<Integer> list = map.get(d);
		if(list == null) {
			list = new ArrayList();
		}
		list.add(node.data);
		map.put(d, list);

		diagonalTraversalUtil(node.left, d+1, map);
		diagonalTraversalUtil(node.right, d, map);
	}


	public void printBoundaryNodes(Node root) {

		if(root == null)
			return;

		printLeftBoundary(root);
		printLeaves(root);
		printRightBoundary(root);
	}

	public void printLeftBoundary(Node node) {
		if(node == null)
			return;

		if(node.left!=null) {
			System.out.print(node.data+" ");
			printLeftBoundary(node.left);
		} else if(node.right!=null) {
			System.out.print(node.data+" ");
			printLeftBoundary(node.right);
		}
	}

	public void printRightBoundary(Node node) {
		if(node == null)
			return;

		if(node.right!=null) {
			printRightBoundary(node.right);
			System.out.print(node.data+" ");
		} else if(node.left!=null) {
			printRightBoundary(node.left);
			System.out.print(node.data+" ");
		}
	}

	public void printLeaves(Node node) {

		if(node == null)
			return;

		printLeaves(node.left);

		if(node.left == null && node.right == null)
			System.out.print(node.data+" ");

		printLeaves(node.right);
	}

	public void verticalTraversal(Node root) {
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap();
		verticalTraversalUtil(root, 0, map);
		for(Integer key: map.keySet()) {
			System.out.print(key+" : ");
			System.out.println(map.get(key));
		}
	}

	public void verticalTraversalUtil(Node node, int d, HashMap<Integer, ArrayList<Integer>> map) {
		if(node == null)
			return;

		ArrayList<Integer> list = map.get(d);
		if(list == null) {
			list = new ArrayList();
		}
		list.add(node.data);
		map.put(d, list);

		verticalTraversalUtil(node.left, d-1, map);
		verticalTraversalUtil(node.right, d+1, map);
	}


	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);

		System.out.println("\nPreorder : ");
		tree.preOrder(tree.root);
		System.out.println("\nPostorder : ");
		tree.postOrder(tree.root);
		System.out.println("\nInorder : ");
		tree.inOrder(tree.root);
		System.out.println("\nLevel Order : ");
		tree.levelOrderTraversal(tree.root);
		System.out.println("\nPreorder Iterative: ");
		tree.preOrderIterative(tree.root);
		System.out.println("\nPostorder Iterative: ");
		tree.postOrderIterative(tree.root);
		System.out.println("\nInorder Iterative: ");
		tree.inOrderIterative(tree.root);
		System.out.println("\nReverse Level Order: ");
		tree.reverseLevelOrder(tree.root);
		System.out.println("\nDiagonal Traversal: ");
		tree.diagonalTraversal(tree.root);
		System.out.println("\nBoundary Traversal: ");
		tree.printBoundaryNodes(tree.root);
		System.out.println("\nVertical Traversal: ");
		tree.verticalTraversal(tree.root);
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
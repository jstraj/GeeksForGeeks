import java.io.*;
import java.util.*;

class HeightBalanced {

	Node root;

	public boolean isBalanced(Node root) {
		
		if(root == null)
			return true;

		int lHeight = height(root.left);
		int rHeight = height(root.right);

		if(Math.abs(lHeight-rHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;
    }

    public int height(Node node) {
    	if(node == null)
    		return 0;

    	return 1+Math.max(height(node.left), height(node.right));
    }

	public static void main(String[] args) 
    {
    	HeightBalanced tree = new HeightBalanced();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
  
        if(tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
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

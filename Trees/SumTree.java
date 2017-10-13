import java.io.*;
import java.util.*;

class SumTree {

	Node root;

	public int toSumTree(Node root) {
		if(root == null)
			return 0;

		int old_val = root.data;

		root.data = toSumTree(root.left)+toSumTree(root.right);
		return root.data+old_val;
	}

	public void printInorder(Node node) 
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

	public static void main(String args[]) {
		SumTree tree = new SumTree();
  
        /* Constructing tree given in the above figure */
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
  
        tree.toSumTree(tree.root);
  
        // Print inorder traversal of the converted tree to test result 
        // of toSumTree()
        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInorder(tree.root);
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

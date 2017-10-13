import java.io.*;
import java.util.*;

class SumTree2 {

	Node root;

	public int toSumTree(Node root) {
		if(root == null)
			return 0;
		
        if(root.left == null && root.right == null)
            return root.data;

        int leftSum = toSumTree(root.left);
        int rightSum = toSumTree(root.right);

        root.data+=leftSum;

        return root.data+rightSum;
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
		SumTree2 tree = new SumTree2();
  
        /* Constructing tree given in the above figure */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        
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

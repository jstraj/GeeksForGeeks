import java.io.*;
import java.util.*;

class Height {

	Node root;

	public int maxDepth(Node root) {
		if(root == null)
			return 0;

	    int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        return Math.max(lDepth+1, rDepth+1);	
    }

	public static void main(String[] args) 
    {
        Height tree = new Height();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + 
                                      tree.maxDepth(tree.root));
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

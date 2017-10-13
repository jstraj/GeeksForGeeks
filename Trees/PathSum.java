import java.io.*;
import java.util.*;

class PathSum {

	Node root;

	public boolean hasPathSum(Node node, int sum) {
		if(node == null)
			return (sum == 0);

		boolean ans = false;
		int subSum = sum - node.data;
		if(subSum == 0 && node.left == null && node.right == null)
			return true;
		if(node.left != null)
			ans = ans || hasPathSum(node.left, subSum);
		if(node.right != null)
			ans = ans || hasPathSum(node.right, subSum);
		return ans;
	    
    }

	public static void main(String[] args) 
    {
    	int sum = 21;
        PathSum tree = new PathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
  
        if (tree.hasPathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
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

import java.io.*;
import java.util.*;

class Distance {
	
	Node root;

	public Node LCA(Node root, int n1, int n2) {
		if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if(left != null && right != null)
            return root;
        if(left == null && right == null)
            return null;

        return left!=null?left:right;
	}

	public int level(Node root, int key, int level) {

		if(root == null)
			return -1;
		if(root.data == key)
			return level;

		int downLevel = level(root.left, key, level+1);
		if(downLevel == -1)
			return level(root.right, key, level+1);
		return downLevel;
	}

	public int findDistance(Node root, int n1, int n2) {

		Node lca = LCA(root, n1, n2);
		int d1 = level(lca, n1, 0);
		int d2 = level(lca, n2, 0);
		System.out.println(lca.data+": "+d1+","+d2);
		return d1+d2;
	}

	public static void main(String args[]) {
		Distance d = new Distance();
		d.root = new Node(1);
        d.root.left = new Node(2);
        d.root.right = new Node(3);
        d.root.left.left = new Node(4);
        d.root.left.right = new Node(5);
        d.root.right.left = new Node(6);
        d.root.right.right = new Node(7);
        d.root.right.left.right = new Node(8);
        
        System.out.println("Dist(4, 5) = "+d.findDistance(d.root, 4, 5));
        System.out.println("Dist(4, 6) = "+d.findDistance(d.root, 4, 6));
        System.out.println("Dist(3, 4) = "+d.findDistance(d.root, 3, 4));
        System.out.println("Dist(2, 4) = "+d.findDistance(d.root, 2, 4));
        System.out.println("Dist(8, 5) = " +d.findDistance(d.root, 8, 5));
	}
}

class Node{
    Node left, right;
    int data;
    Node(int key){
        this.data = key;
        left = null;
        right = null;
    }
}
import java.io.*;
import java.util.*;

class CommonAncestors {
	
	Node root;

	public Node LCA(Node root, int n1, int n2) {
		
        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if(root.left != null && root.right!=null)
            return root;

        if(root.left == null && root.right == null)
            return null;

        return left!=null:left?right;
	}

    public boolean printAncestors(Node root, int lca) {
        if(root == null)
            return false;
        if(root.data == lca) {
            System.out.print(root.data+" ");
            return true;
        }

        if(printAncestors(root.left, lca) || printAncestors(root.right, lca)) {
            System.out.println(root.data+" ");
            return true;
        }

        return false;

    }

    public boolean findCommonNodes(Node root, int n1, int n2) {

        Node lca = LCA(root, n1, n2);
        if(lca == null)
            return false;

        printAncestors(root, LCA.data);
        return true;
    }
	

	public static void main(String args[]) {
		CommonAncestors d = new CommonAncestors();
		d.tree.root = new Node(1);
        d.tree.root.left = new Node(2);
        d.tree.root.right = new Node(3);
        d.tree.root.left.left = new Node(4);
        d.tree.root.left.right = new Node(5);
        d.tree.root.right.left = new Node(6);
        d.tree.root.right.right = new Node(7);
        d.tree.root.left.left.left = new Node(8);
        d.tree.root.right.left.left = new Node(9);
        d.tree.root.right.left.right = new Node(10);
  
        if (findCommonNodes(root, 9, 7) == false)
            System.out.println("No Common nodes");
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
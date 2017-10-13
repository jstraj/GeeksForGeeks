import java.io.*;
import java.util.*;

class inpreOrder {
	
	Node root;
	int preIndex = 0;
	public inpreOrder() {
		root = null;
	}

	public Node buildTree(char[] in, char[] pre, int inStart, int inEnd) {

		if(inStart > inEnd)
			return null;

		Node tNode = new Node(pre[preIndex++]);

		if(inStart == inEnd)
			return tNode;

		int inIndex = search(in, inStart, inEnd, tNode.data);

		tNode.left = buildTree(in, pre, inStart, inIndex-1);
		tNode.right = buildTree(in, pre, inIndex+1, inEnd);

		return tNode;
	}

	public int search(char[] arr, int start, int end, char value) {
		int i;
		for(i=start;i<=end;i++)
			if(arr[i] == value)
				return i;
		return i;
	}

	public void inOrder(Node root) {
		if(root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}


	public static void main(String args[]) {
		inpreOrder tree = new inpreOrder();
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        tree.root = tree.buildTree(in, pre, 0, in.length-1);
        tree.inOrder(tree.root);
	}

}

class Node {
	char data;
	Node left, right;
	public Node(char data) {
		this.data = data;
		left = null;
		right = null;
	}
}
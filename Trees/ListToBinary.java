import java.io.*;
import java.util.*;

class ListToBinary {

	ListNode head;
	BinaryTreeNode root;

	public void push(int new_data) {
		ListNode node = new ListNode(new_data);
		node.next = head;
		head = node;
	}

	public BinaryTreeNode convertList2Binary(BinaryTreeNode node) {
		Queue<BinaryTreeNode> q = new LinkedList();
		if(head == null) {
			root = null;
			return null;
		}

		node = new BinaryTreeNode(head.data);
		q.add(node);

		head = head.next;

		while(head!=null) {
			BinaryTreeNode parent = q.peek();
			BinaryTreeNode pp = q.poll();

			BinaryTreeNode leftChild = null, rightChild = null;
			leftChild = new BinaryTreeNode(head.data);
			q.add(leftChild);
			head = head.next;
			if(head!=null) {
				rightChild = new BinaryTreeNode(head.data);
				q.add(rightChild);
				head = head.next;
			}
			parent.left = leftChild;
			parent.right = rightChild;
		}
		return node;
	}
	

	public void inOrder(BinaryTreeNode root) {
		if(root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public static void main(String args[]) {
		ListToBinary tree = new ListToBinary();
        tree.push(36); /* Last node of Linked List */
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10); /* First node of Linked List */
        BinaryTreeNode node = tree.convertList2Binary(tree.root);
  
        System.out.println("Inorder Traversal of the"+
                        " constructed Binary Tree is:");
        tree.inOrder(node);
	}
}

class BinaryTreeNode {
	int data;
	BinaryTreeNode left, right;
	public BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class ListNode {
	int data;
	ListNode next;
	public ListNode(int data) {
		this.data = data;
	}
}
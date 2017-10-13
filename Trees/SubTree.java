class SubTree {

	Node root1, root2;

	public boolean isSubtree(Node root1, Node root2) {

		if(root2 == null)
            return true;
        if(root1 == null)
            return false;

        if(areIdentical(root1, root2))
            return true;

        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
	}

    public boolean areIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        return root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }
	
	public static void main(String[] args) 
    {
        SubTree tree = new SubTree();
  
        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);
  
        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
  
    }
}


class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
  
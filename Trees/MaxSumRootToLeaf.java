class MaxSumRootToLeaf {

	Node root;

    public int maxSumPath(Node root) {

        if(root == null)
            return 0;

        int left = maxSumPath(root.left);
        int right = maxSumPath(root.right);

        return (left>right?left:right) + root.data;
    }

    public boolean printMaxPath(Node root, int sum) {
        if(sum == 0)
            return true;
        if(root == null)
            return false;

        boolean left = printMaxPath(root.left, sum-root.data);
        boolean right = printMaxPath(root.right, sum-root.data);

        if(left || right)
            System.out.print(root.data+" ");
        return left || right;
    }

	public static void main(String[] args) 
    {
        MaxSumRootToLeaf tree = new MaxSumRootToLeaf();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        System.out.println("Following are the nodes "+
                        "on maximum sum path");
        int sum = tree.maxSumPath(tree.root);
        tree.printMaxPath(tree.root, sum);
        System.out.println("");
        System.out.println("Sum of nodes is : " + sum);
  
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
  
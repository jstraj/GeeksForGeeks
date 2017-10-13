class SumTree3 {

	Node root;

    public boolean isSumTree2(Node node) {

        int ls, rs;
        if(node == null || isLeaf(node))
            return true;

        if(isSumTree2(node.left) && isSumTree2(node.right)) {

            if(node.left == null)
                ls = 0;
            else if(isLeaf(node.left))
                ls = node.left.data;
            else
                ls = 2*node.left.data;

            if(node.right == null)
                rs = 0;
            else if(isLeaf(node.right))
                rs = node.right.data;
            else
                rs = 2*node.right.data;

            if((node.data == rs+ls))
                return true;
            return false;
        }
        return false;
    }

    boolean isLeaf(Node node) 
    {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

	public boolean isSumTree(Node node) {

        if(node == null || (node.left == null && node.right == null))
            return true;

        int ls = sum(node.left);
        int rs = sum(node.right);

        if((node.data == ls+rs) && isSumTree(node.left) && isSumTree(node.right))
            return true;

        return false;
    }

    public int sum(Node node) {
        if(node == null)
            return 0;
        return sum(node.left) + node.data + sum(node.right);
    }

	public static void main(String[] args) 
    {
        SumTree3 tree = new SumTree3();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
  
        if (tree.isSumTree(tree.root))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");

        if (tree.isSumTree2(tree.root))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
  
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
  
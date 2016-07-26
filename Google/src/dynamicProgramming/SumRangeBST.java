package dynamicProgramming;
class TreeNode {
	 
    int data;
    TreeNode left, right;
 
    TreeNode(int d) {
        data = d;
        left = right = null;
    }
}
public class SumRangeBST {
	static TreeNode root;
    public static int sumRangeBST(TreeNode node, int k1, int k2) {
        /* base case */
        if (node == null) return 0;
        int sum = 0;
        if (k1 < node.data) {
            sum+=sumRangeBST(node.left, k1, k2);
        }
        if (k1 <= node.data && k2 >= node.data) {
            sum+=node.data;
        }
        if (k2 > node.data) {
            sum+=sumRangeBST(node.right, k1, k2);
        }
        return sum;
    }
    public static void main(String[] args) {
        SumRangeBST tree = new SumRangeBST();
        int k1 = 10, k2 = 25;
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
 
        System.out.println(tree.sumRangeBST(root, k1, k2));
        //System.out.println(sum);
    }
}

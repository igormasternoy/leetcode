package trees.graphs;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

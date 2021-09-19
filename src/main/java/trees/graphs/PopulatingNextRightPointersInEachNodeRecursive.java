package trees.graphs;

import utils.BTreePrinter;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeRecursive {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        BTreePrinter.printNode(node);

        connect(node.left, node.right);

        BTreePrinter.printNode(node);
    }

    public static void connect(TreeNode left, TreeNode right) {
        if(left == null || right == null){
            return;
        }
        left.next = right;
        connect(left.left, left.right);
        connect(right.left, right.right);

        if(left.right !=null && right.left!=null ){
            left.right.next = right.left;
        }

    }


}

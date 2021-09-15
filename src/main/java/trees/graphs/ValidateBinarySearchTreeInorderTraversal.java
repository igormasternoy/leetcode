package trees.graphs;

import utils.BTreePrinter;
import utils.Printer;

/**
 * DFS
 * Remove MiN/MaX value and just set it to nulls and add condition
 */
public class ValidateBinarySearchTreeInorderTraversal {

    public static void main(String[] args) {
//        TreeNode head = new TreeNode(5, new TreeNode(1), new TreeNode(6, new TreeNode(3), new TreeNode(7)));

//        TreeNode head = new TreeNode(0, new TreeNode(1), null);

        TreeNode head = new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27))),
                new TreeNode(47, null, new TreeNode(56)));

//        TreeNode head = new TreeNode(3, null, new TreeNode(30,
//                new TreeNode(10, null , new TreeNode(15, null, new TreeNode(45)))));

//        TreeNode head = new TreeNode(-2147483648,  null , new TreeNode(Integer.MAX_VALUE));

        BTreePrinter.printNode(head);
        System.out.println(checkTreeNode(head));

    }

    private static Integer prev;

    public static boolean checkTreeNode(TreeNode root) {

        if(root == null){
            return true;
        }

        if(!checkTreeNode(root.left)){
            return false;
        }

        if(prev != null && root.val <= prev ){
            return false;
        }

        prev = root.val;
        return checkTreeNode(root.right);

    }

}

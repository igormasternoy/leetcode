package trees.graphs;

import utils.Printer;

/**
 * DFS
 * Remove MiN/MaX value and just set it to nulls and add condition
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
//        TreeNode head = new TreeNode(5, new TreeNode(1), new TreeNode(6, new TreeNode(3), new TreeNode(7)));

//        TreeNode head = new TreeNode(0, new TreeNode(1), null);

//        TreeNode head = new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27))),
//                new TreeNode(47, null, new TreeNode(56)));

//        TreeNode head = new TreeNode(3, null, new TreeNode(30,
//                new TreeNode(10, null , new TreeNode(15, null, new TreeNode(45)))));

        TreeNode head = new TreeNode(-2147483648,  null , new TreeNode(Integer.MAX_VALUE));


        Printer.printTreeNode(head);
        System.out.println(checkTreeNode(false, head.val, Long.MAX_VALUE, head, head.right));
        System.out.println(checkTreeNode(true, Long.MIN_VALUE, head.val, head, head.left));

    }

    public static boolean checkTreeNode(boolean isLeft, long min, long max, TreeNode parent, TreeNode node) {
        if (node == null) return true;

//        System.out.printf("%s %s current: %s next maxmin: %s\n", parent.val, node.val, value, nextMaximum(isMax, value, node));

        boolean checkWithParent = isLeft ? parent.val > node.val : parent.val < node.val;
        boolean checkWithInterval =  node.val > min && node.val < max;

//        int rightMax = Math.max(node.val, max);
//        int leftMin = Math.min(node.val, min);

        boolean rightSide = checkTreeNode(false, node.val, max, node, node.right);
        boolean leftSide = checkTreeNode(true, min, node.val, node, node.left);

        System.out.printf("SIDE: %s, parent: %s node: %s min: %s max: %s, rightSide %s leftSide %s\n",
                isLeft ? "left":"right", parent.val, node.val, min, max, rightSide, leftSide);


        return checkWithParent &&
                checkWithInterval &&
                rightSide && leftSide;


    }

}

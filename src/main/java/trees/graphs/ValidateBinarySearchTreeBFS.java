package trees.graphs;

import utils.Printer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * DFS
 */
public class ValidateBinarySearchTreeBFS {
    private static Deque<TreeNode> stack = new LinkedList();
    private static Deque<Integer> upperLimits = new LinkedList();
    private static Deque<Integer> lowerLimits = new LinkedList();


    public static void main(String[] args) {
//        TreeNode head = new TreeNode(5, new TreeNode(1), new TreeNode(6, new TreeNode(3), new TreeNode(7)));

//        TreeNode head = new TreeNode(0, new TreeNode(1), null);

//        TreeNode head = new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27))),
//                new TreeNode(47, null, new TreeNode(56)));

        TreeNode head = new TreeNode(3, null, new TreeNode(30,
                new TreeNode(10, null , new TreeNode(15, null, new TreeNode(45)))));

//        TreeNode head = new TreeNode(-2147483648, null, new TreeNode(Integer.MAX_VALUE));


        Printer.printTreeNode(head);
        System.out.println(checkTreeNode(head));
    }


    public static void update(TreeNode root, Integer low, Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

    public static boolean checkTreeNode(TreeNode root) {

        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.val;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }


}

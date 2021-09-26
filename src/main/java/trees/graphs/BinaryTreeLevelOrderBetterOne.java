package trees.graphs;

import utils.BTreePrinter;
import utils.Printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderBetterOne {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3, null, new TreeNode(2, new TreeNode(1)));
//        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(11);
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, p, new TreeNode(9, null, q)));
        BTreePrinter.printNode(root);
        List<Integer> values = new ArrayList<>();

        levelOrder(root).forEach(el -> Printer.printList(el));

    }

    public static List<List<Integer>> levelOrder(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (node == null) {
            return result;
        }

        stack.push(node);

        while (!stack.isEmpty()) {

            List<Integer> level = new LinkedList<>();

            int stackSize = stack.size();
            while(stackSize != 0){
                TreeNode curr = stack.removeLast();
                level.add(curr.val);

                if (curr.left != null) {
                    stack.push( curr.left );
                }
                if (curr.right != null) {
                    stack.push( curr.right );
                }

                stackSize--;
            }
            result.add(level);

        }
        return result;

    }
}

package trees.graphs;

import utils.BTreePrinter;
import utils.Printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrder {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));

//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3, null , new TreeNode(5)));
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6) , new TreeNode(7)));
        BTreePrinter.printNode(root);
        LinkedList<Integer> stack = new LinkedList<Integer>();
//        stack.push(1);
//        stack.push(2);
//
//        System.out.println(stack.pollLast());
//        stack.push(3);
//        System.out.println(stack.pollLast());


        levelOrder(root).forEach(el -> Printer.printList(el));

    }

    public static List<List<Integer>> levelOrder(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (node == null) {
            return result;
        }

        stack.push(node);

        boolean zig = false;
        while (!stack.isEmpty()) {

            List<Integer> level = new LinkedList<>();

            int stackSize = stack.size();
            while (stackSize != 0) {
                TreeNode curr;
                if (zig)
                    curr = stack.pollFirst();
                else
                    curr = stack.pollLast();


                System.out.println(curr.val);
                level.add(curr.val);


                if(!zig) {
                    addChild(stack, zig, curr.left);
                    addChild(stack, zig, curr.right);
                }else{
                    addChild(stack, zig, curr.right);
                    addChild(stack, zig, curr.left);
                }


                stackSize--;
            }
            zig = !zig;
            result.add(level);

        }
        return result;

    }

    private static void addChild(LinkedList<TreeNode> stack, boolean zig, TreeNode node) {
        if (node != null) {
            if (zig)
                stack.addLast(node);
            else
                stack.push(node);
        }
    }
}

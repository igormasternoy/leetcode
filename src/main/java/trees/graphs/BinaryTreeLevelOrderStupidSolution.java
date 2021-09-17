package trees.graphs;

import utils.BTreePrinter;
import utils.Printer;

import java.util.*;

public class BinaryTreeLevelOrderStupidSolution {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3, null, new TreeNode(2, new TreeNode(1)));
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        BTreePrinter.printNode(root);
        List<Integer> values = new ArrayList<>();

        levelOrder(root).forEach(el -> Printer.printList(el));

    }

    static class TreeNodeLevel{
        TreeNode node;
        int level;

        public TreeNodeLevel(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode node) {
        Stack<TreeNodeLevel> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

//        result.add(new ArrayList<Integer>(Arrays.asList(node.val)) );

        stack.push(new TreeNodeLevel(0, node));

        while (!stack.isEmpty()) {
            TreeNodeLevel curr = stack.pop();
            System.out.println(curr.node.val);

            if(result.size() <= curr.level){
                List<Integer> list = new ArrayList<>();
                list.add(curr.node.val);
                result.add(curr.level, list);
            }else{
                result.get(curr.level)
                      .add(curr.node.val);
            }

            if (curr.node.right != null) {
                stack.push( new TreeNodeLevel(curr.level+1, curr.node.right) );
            }
            if (curr.node.left != null) {
                stack.push( new TreeNodeLevel(curr.level+1, curr.node.left) );
            }
        }
        return result;

    }
}

package trees.graphs;

import utils.BTreePrinter;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalBFS {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3, null, new TreeNode(2, new TreeNode(1)));
        TreeNode root = new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1)));
//        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        BTreePrinter.printNode(root);

        inorderTraversal(root);
        Printer.printList(result);
    }

    private static List<Integer> result = new ArrayList<>();
    private static Stack<TreeNode> stack = new Stack<>();

    public static void inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

    }
}

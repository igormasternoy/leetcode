package trees.graphs;

import utils.BTreePrinter;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3, null, new TreeNode(2, new TreeNode(1)));
//        TreeNode root = new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1)));
//        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));

        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(11);
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, p, new TreeNode(9, null, q)));
        BTreePrinter.printNode(root);
        List<Integer> values = new ArrayList<>();
        inorderTraversal(values, root);
        Printer.printList(values);
    }

    private static TreeNode prev;

    public static TreeNode inorderTraversal(List<Integer> values, TreeNode root) {

        if(root == null){
            return root;
        }

        if(inorderTraversal(values, root.left) == null){
            values.add(root.val);
            System.out.println(root.val);
        }

        return inorderTraversal(values, root.right);

    }
}

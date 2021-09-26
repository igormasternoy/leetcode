package trees.graphs;

import utils.BTreePrinter;

import java.util.LinkedList;

public class LowestCommonAncestorBSTRecursiveOne {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(11);
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, p, new TreeNode(9, null, q)));

        BTreePrinter.printNode(root);

        System.out.println(lowestCommonAncestor(root, p, q));


    }

    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root; //split point found
        }


    }


}

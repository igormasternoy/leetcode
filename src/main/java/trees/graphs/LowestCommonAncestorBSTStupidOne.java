package trees.graphs;

import utils.BTreePrinter;

import java.util.LinkedList;
import java.util.Stack;

public class LowestCommonAncestorBSTStupidOne {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(11);
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, p, new TreeNode(9, null, q)));

        BTreePrinter.printNode(root);

        System.out.println(lowestCommonAncestor(root, p, q));


    }

    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        LinkedList<TreeNode> path1 = findPath(root, p);
        LinkedList<TreeNode> path2 = findPath(root, q);

        TreeNode lca = null;

        while(!path1.isEmpty() || !path2.isEmpty()){
            TreeNode p1 = path1.pollLast();
            TreeNode p2 = path2.pollLast();
            if(p1 == null || p2 == null){
                break;
            }

            if( p1.val == p2.val){
                lca=p1;
            }else{
                break;
            }

        }
        return lca;
    }

    private static LinkedList<TreeNode> findPath(TreeNode root, TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(true){
            TreeNode curr = stack.peekFirst();
            if(curr.val == node.val){
                return stack;
            }else if(node.val > curr.val){
                stack.push(curr.right);
            }else{
                stack.push(curr.left);
            }
        }

    }


}

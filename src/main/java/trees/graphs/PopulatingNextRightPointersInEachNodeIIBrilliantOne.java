package trees.graphs;

import utils.BTreePrinter;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeIIBrilliantOne {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(7)));

        BTreePrinter.printNode(node);

        connect(node);

        BTreePrinter.printNode(node);
    }

    public static TreeNode leftmost = null;
    public static TreeNode prev = null;

    public static void connectChild(TreeNode node){
        if(node == null){
            return;
        }

        if(prev == null){
            leftmost = node; //It's a first node;
        }else{
            prev.next = node; //We are not the first - connect to previous
        }

        prev = node;
    }

    public static TreeNode connect(TreeNode node) {
        if(node == null) return null;

        leftmost = node;
        TreeNode curr;

        while(leftmost != null){

            prev = null;
            curr = leftmost;
            leftmost = null;

            while(curr != null){
                connectChild(curr.left);
                connectChild(curr.right);
                curr = curr.next;
            }
        }
        return node;
    }


}

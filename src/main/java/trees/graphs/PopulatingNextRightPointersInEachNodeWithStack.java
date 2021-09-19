package trees.graphs;

import utils.BTreePrinter;

import java.util.LinkedList;
import java.util.Stack;

public class PopulatingNextRightPointersInEachNodeWithStack {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        BTreePrinter.printNode(addRightPointers(node));
    }

    public static TreeNode addRightPointers(TreeNode node){

        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(node);

        while(!stack.isEmpty()){

            int stackSize = stack.size();
            while(stackSize != 1) {
                TreeNode left = stack.pollLast();
                TreeNode right = stack.peekLast();
                left.next = right;


                pushToStackIfNotNull(left.left, stack);
                pushToStackIfNotNull(left.right, stack);

                stackSize--;
            }

           TreeNode right= stack.pollLast();
//            if(right != null) {
                pushToStackIfNotNull(right.left, stack);
                pushToStackIfNotNull(right.right, stack);
//            }

        }

        return node;
    }

    private static void pushToStackIfNotNull(TreeNode node, LinkedList<TreeNode> stack){
        if(node != null){
            stack.push(node);
        }

    }
}

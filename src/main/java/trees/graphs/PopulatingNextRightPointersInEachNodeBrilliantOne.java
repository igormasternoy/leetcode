package trees.graphs;

import utils.BTreePrinter;

public class PopulatingNextRightPointersInEachNodeBrilliantOne {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        BTreePrinter.printNode(node);

        connect(node);

        BTreePrinter.printNode(node);
    }

    public static TreeNode connect(TreeNode node) {
        if(node == null) return null;

        TreeNode leftmost = node;

        while(leftmost.left != null){
            TreeNode head = leftmost;

            while(head!=null){
                head.left.next = head.right;

                if (head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return node;
    }


}

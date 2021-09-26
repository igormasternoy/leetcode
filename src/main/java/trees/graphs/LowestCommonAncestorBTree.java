package trees.graphs;

import utils.BTreePrinter;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestorBTree {

    static class TreeNodePath{
        LinkedList<TreeNode> path = new LinkedList<>();
        TreeNode node;

        TreeNodePath(TreeNode node){
            this.node = node;
        }

        TreeNodePath(TreeNode node, LinkedList<TreeNode> path){
            this.node = node;
            this.path = path;
        }

        int val(){
            return node.val;
        }

        LinkedList<TreeNode> addNodeToPath(TreeNode newNode){
            LinkedList<TreeNode> newPath = new LinkedList<>(path);
            newPath.add(newNode);
            return newPath;
        }

        @Override
        public String toString() {
            return "TreeNodePath{" +
                    "node=" + node +
                    '}';
        }
    }

    public static void main(String[] args) {

        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(11);
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, p, new TreeNode(9, null, q)));

        BTreePrinter.printNode(root);

        System.out.println(lowestCommonAncestor(root, p, q));


    }

    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;

        Stack<TreeNodePath> stack = new Stack<>();
        TreeNodePath  rootPath = new TreeNodePath(root);
        rootPath.path.add(root);
        stack.push(rootPath);

        LinkedList<TreeNode> pPath = null;
        LinkedList<TreeNode> qPath = null;

        while(qPath == null || qPath == null || !stack.isEmpty()){
            TreeNodePath nodeWithPath = stack.pop();

            if(pPath == null && nodeWithPath.val() == p.val){
                pPath = nodeWithPath.path;
            }

            if(qPath == null && nodeWithPath.val() == q.val){
                qPath = nodeWithPath.path;
            }

            if(nodeWithPath.node.left != null) {
                stack.push(new TreeNodePath(nodeWithPath.node.left, nodeWithPath.addNodeToPath(nodeWithPath.node.left)));
            }
            if(nodeWithPath.node.right != null) {
                stack.push(new TreeNodePath(nodeWithPath.node.right, nodeWithPath.addNodeToPath(nodeWithPath.node.right)));
            }

        }

        while(!pPath.isEmpty() || !qPath.isEmpty()){
            TreeNode pAnc = pPath.pollFirst();
            TreeNode qAnc = qPath.pollFirst();

            if(pAnc == qAnc){
                lca = pAnc;
            }else{
                break;
            }
        }

        return lca;
    }

}

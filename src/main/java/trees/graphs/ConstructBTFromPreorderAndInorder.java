package trees.graphs;

import utils.BTreePrinter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreorderAndInorder {
    static int[] inorder = new int[]{9,  3, 15, 20, 7};
    static int[] preorder = new int[]{3, 9, 20, 15, 7};
    public static void main(String[] args) {



        BTreePrinter.printNode(buildTree(preorder, inorder));

    }

    static int preorderIndex;
    static Map<Integer, Integer> inorderIndexMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private static TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;
        System.out.println("Current inorder:" + Arrays.toString(Arrays.copyOfRange(inorder, left, right+1)));
        System.out.println("Current preorder index:" + preorder[preorderIndex]);

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}

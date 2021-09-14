package utils;

import linked.lists.ListNode;
import linked.lists.Node;
import trees.graphs.TreeNode;

import java.util.List;

public class Printer {

    public static void printTreeNode(TreeNode matrix) {
        if(matrix == null){
            System.out.println("Nil");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matrix.val);
        sb.append('\n');
        printTreeNode(0, true, sb, matrix.right);
        printTreeNode(0, false, sb, matrix.left);

        System.out.println(sb);
    }

    private static void printTreeNode(int shift, boolean isRight, StringBuilder buffer, TreeNode matrix) {
        if (matrix == null) {
            return;
        }
        buffer.append((shift == 0) ? "" : String.format("├%" + shift + "s", ""));
        buffer.append(isRight ? "├── " : "└── ");
        buffer.append(matrix.val);
        buffer.append("\n");

        int nextShit = shift+4;
        printTreeNode(nextShit, true, buffer, matrix.right);
        printTreeNode(nextShit, false, buffer, matrix.left);


    }

    public static void printNodes(Node input) {
        while (input != null) {
            System.out.printf("%s -> ", input.val);
            input = input.next;
        }
        System.out.print("null\n");
    }

    public static void printNodesHashes(Node input) {
        while (input != null) {
            System.out.printf("(%s, %s) -> (%s %s) -->", input.val,
                    input.hashCode(),
                    input.random == null ? null : input.random.val,
                    input.random == null ? null : input.random.hashCode());
            input = input.next;
        }
        System.out.print("null\n");
    }

    public static void printListNodes(ListNode input) {
        while (input != null) {
            System.out.printf("%s -> ", input.val);
            input = input.next;
        }
        System.out.print("null\n");
    }

    public static void printList(List<Integer> list) {
        list.forEach(el -> {
            System.out.printf("%s, ", el);
        });
        System.out.println();
    }

    public static void printMatrix(long[][] matrix) {
        for (long[] ints : matrix) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void printMatrix(int[][] matrix) {
        printMatrix(matrix, true);
    }

    public static void printMatrix(int[][] matrix, boolean newLine) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        if (newLine) System.out.println();
    }
}

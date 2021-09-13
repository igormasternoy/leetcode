package utils;

import linked.lists.ListNode;
import linked.lists.Node;

import java.util.List;

public class Printer {

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

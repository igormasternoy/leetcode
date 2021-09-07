package utils;

import java.util.Collections;
import java.util.List;

public class MatrixPrinter {

    public static void printList(List<Integer> list){
        list.forEach(el -> {
            System.out.printf("%s, ", el);
        });
        System.out.println();
    }


    public static void printMatrix(int[][] matrix){
        printMatrix(matrix,true);
    }

    public static void printMatrix(int[][] matrix, boolean newLine){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        if(newLine) System.out.println();
    }
}
